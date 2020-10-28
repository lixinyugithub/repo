package com.nbteam.hislite.payment.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Objects;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.pay.dto.PaymentOrder;
import com.nbteam.hislite.payment.api.pay.dto.PaymentSerial;
import com.nbteam.hislite.payment.api.pay.vo.ClosePayOrderVo;
import com.nbteam.hislite.payment.api.pay.vo.PayMsgContent;
import com.nbteam.hislite.payment.api.pay.vo.PaySerialVo;
import com.nbteam.hislite.payment.pay.mapper.PaymentOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class AsyncProcessOrderService
{
	private static final Logger logger = LoggerFactory.getLogger(AsyncProcessOrderService.class);

	@Autowired
	private PaymentOrderService paymentOrderService;

	@Autowired
	private PaymentOrderMapper paymentOrderMapper;

	@Autowired
	private PaymentSerialService paymentSerialService;

	@Async
	public void closeQrSerilOrders(Long payOrderId, Long paySerilId) {
		if (logger.isDebugEnabled()) {
			logger.debug("异步处理关闭支付成功后的多余支付流水单");
		}
		if (paySerilId == null || paySerilId == null) {
			return;
		}
		try {
			List<PaymentSerial> serilList = paymentSerialService.getSerialOrdersByPayId(payOrderId);
			if (CollectionUtils.isEmpty(serilList)) {
				return;
			}
			for (PaymentSerial seril : serilList) {
				if (paySerilId.equals(seril.getPaySerialId())) {
					continue;
				}
				// 处理关闭订单
				if (PaymentConstants.SERIL_STATUS_INIT.equals(seril.getStatus())) {
					PaySerialVo serilVo = new PaySerialVo();
					BeanUtils.copyProperties(seril, serilVo);
					ClosePayOrderVo result = paymentOrderService.closePayOrder(serilVo);
					if (PaymentConstants.RESULT_SUCCESS_CODE.equals(result.getResultCode())) {
						PaymentSerial updateSeril = new PaymentSerial();
						updateSeril.setStatus(PaymentConstants.PAY_STATUS_CANCELED);
						updateSeril.setRevokeTime(new Date());
						updateSeril.setPaySerialId(seril.getPaySerialId());
						paymentSerialService.update(updateSeril);
					}
				}
			}
		} catch (Exception e) {
			logger.error("异步处理关闭支付成功后的多余支付流水单异常", e);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("异步处理关闭支付成功后的多余支付流水单调用结束");
			}
		}
	}

	/**
	 *
	 * 发送MQ消息通知业务. <br/>
	 *
	 * @param payOrderId
	 */
	public void sendPaySuccessMsg(Long payOrderId) {
		PaymentOrder order = paymentOrderMapper.selectByPrimaryKey(payOrderId);
		if (order == null) {
			logger.error("订单号：{}，找不到对应的订单信息", payOrderId);
			return;
		}
		// 判断是否支付成功
		if (!Objects.equal(order.getStatus(), PaymentConstants.PAY_STATUS_SUCCESS)) {
			logger.warn("订单非成功状态，无需通知业务");
			return;
		}
		// 已经通知的，不需要再次通知
		if (PaymentConstants.YES.equals(order.getNoticeBizFlag())) {
			logger.warn("订单[{}]已通知业务，无需重复通知", payOrderId);
			return;
		}
		PayMsgContent payMsg = new PayMsgContent();
		payMsg.setType(PaymentConstants.PAY_MSG_TYPE_PAYED);
		JSONObject result = new JSONObject();
		if (PaymentConstants.PAY_STATUS_SUCCESS.equals(order.getStatus())) {
			payMsg.setCode(PaymentConstants.RESULT_SUCCESS_CODE);
			result.put("code", "0");
			result.put("paySerilNo", order.getAcquirerSerialNo());
			result.put("orderType", order.getBizType());
			result.put("totalRealPay", order.getRealTotalFee());
			result.put("payedTime", order.getPayedTime());
			result.put("payType", order.getPayMode());
			result.put("orderId", order.getBizOrderId());
			result.put("medicalFlag", 1); // 1-自费 2-全医保 3-医保+自费
			// 医保支付返回数据
			if (PaymentConstants.YES.equals(order.getIsMedPay())) {
				logger.error("支付订单：不支持医保", payOrderId);
				payMsg.setCode(PaymentConstants.RESULT_FAIL_CODE);
				payMsg.setMsg("PAY_FAILURE");
			}
		} else if (PaymentConstants.PAY_STATUS_FAILURE.equals(order.getStatus())) {
			logger.error("支付订单：[{}]未支付成功", payOrderId);
			payMsg.setCode(PaymentConstants.RESULT_FAIL_CODE);
			payMsg.setMsg("PAY_FAILURE");
		} else {
			payMsg.setCode(PaymentConstants.RESULT_UNKNOW_CODE);
			payMsg.setMsg("PAY_UNKNOW");
		}
		payMsg.setContent(result);
		// TODO 发送消息通知业务
		// pay2OrderMQProducer.sendMessage(JSONObject.toJSONString(payMsg));
		// 发送完成后，更改发送标志
		if (PaymentConstants.PAY_STATUS_SUCCESS.equals(order.getStatus())) {
			PaymentOrder updateOrder = new PaymentOrder();
			updateOrder.setPayOrderId(order.getPayOrderId());
			updateOrder.setNoticeBizFlag(PaymentConstants.YES);
			paymentOrderService.update(updateOrder);
		}
	}

}
