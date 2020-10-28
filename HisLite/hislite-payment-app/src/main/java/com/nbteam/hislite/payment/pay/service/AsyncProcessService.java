package com.nbteam.hislite.payment.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.nbteam.hislite.common.utils.CommonUtil;
import com.nbteam.hislite.common.utils.DateTool;
import com.nbteam.hislite.common.utils.MoneyCovert;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchant;
import com.nbteam.hislite.payment.api.pay.dto.PaymentSerial;
import com.nbteam.hislite.payment.api.pay.vo.AsyncWeixinResultVo;
import com.nbteam.hislite.payment.pay.utils.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
public class AsyncProcessService
{
	private static final Logger logger = LoggerFactory.getLogger(AsyncProcessService.class);

	@Autowired
	private PaymentSerialService paymentSerialService;

	@Autowired
	private PaymentMerchantService paymentMerchantService;

	@Autowired
	private AsyncProcessOrderService asyncProcessOrderService;

	public Boolean asyncWeixinPayResult(String payResultXML) {
		logger.info("处理微信异步支付回调结果:{}", JSONObject.toJSONString(payResultXML));
		try {
			if (StringUtils.isBlank(payResultXML)) {
				logger.warn("处理微信异步支付回调结果数据为空");
				return false;
			}
			AsyncWeixinResultVo vo = CommonUtil.getObjectFromXML(payResultXML, AsyncWeixinResultVo.class);
			PaymentSerial serilOrder = null;
			if (StringUtils.isNotBlank(vo.getOut_trade_no())) {
				serilOrder = paymentSerialService.getPaySerilInfoByMerchantOrderId(vo.getOut_trade_no());
				// 找不到支付订单，需要抛出异常，将消息重新进入队列，直到人工处理
				if (serilOrder == null) {
					logger.error("处理微信异步支付回调，查询流水信息不存在 ");
					throw new PaymentException(PaymentException.DEFAULT_CODE, "找不到对应的支付订单");
				}
				// 如果已经支付成功，则不再处理
				if (PaymentConstants.SERIL_STATUS_SUCCESS.equals(serilOrder.getStatus())) {
					logger.warn("流水订单：{}，已支付完成，无需再次处理", serilOrder.getPaySerialId());
					return true;
				}
				// 校验支付金额是否和订单金额一致
				if (!Objects.equals(vo.getTotal_fee(), serilOrder.getTotalFee())) {
					logger.error("支付金额：{},和通知金额:{},不一致", serilOrder.getTotalFee(),
							vo.getTotal_fee());
					throw new PaymentException(PaymentException.DEFAULT_CODE, "支付金额和通知金额不一致");
				}
			} else {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "获取不到对应的回调支付订单号");
			}
			PaymentSerial updateSeril = new PaymentSerial();
			updateSeril.setPaySerialId(serilOrder.getPaySerialId());
			updateSeril.setPayOrderId(serilOrder.getPayOrderId());
			updateSeril.setPayChannel(serilOrder.getPayChannel());
			updateSeril.setPayMode(serilOrder.getPayMode());
			updateSeril.setInsideMerchantId(serilOrder.getInsideMerchantId());
			updateSeril.setMerchantId(serilOrder.getMerchantId());
			if (!PaymentConstants.RESULT_SUCCESS_CODE.equals(vo.getResult_code())
					|| !PaymentConstants.RETURN_CODE_SUCCESS.equals(vo.getReturn_code())) {
				logger.error("微信支付回调结果错误：{}", vo.getReturn_msg() + vo.getErr_code_des());
				// 支付失败后，需要修改订单信息为失败订单
				updateSeril.setStatus(PaymentConstants.SERIL_STATUS_FAILURE);
				updateSeril.setExtFields(vo.getReturn_msg() + vo.getErr_code_des());
			} else {
				// 校验签名
				PaymentMerchant merchant = paymentMerchantService.getMerchantInfoByPrimaryKey(serilOrder.getInsideMerchantId());
				if (merchant == null) {
					logger.error("流水单：{}，商户信息不存在", serilOrder.getInsideMerchantId());
					throw new PaymentException(PaymentException.DEFAULT_CODE, "商户信息不存在");
				}
				if (!SignUtil.compareResultSign(payResultXML, merchant.getPaymentKey())) {
					logger.error("签名验证异常");
					throw new PaymentException(PaymentException.DEFAULT_CODE, "签名校验不通过");
				}
				updateSeril.setStatus(PaymentConstants.SERIL_STATUS_SUCCESS);
				updateSeril.setBank(vo.getBank_type());
				updateSeril.setTotalFee(vo.getTotal_fee());
				if (StringUtils.isNotBlank(vo.getTime_end())) {
					Date payedTime = DateTool.getSimpleDateTime().parse(vo.getTime_end());
					updateSeril.setPayedTime(payedTime);
				}
				updateSeril.setAcquireSerialNo(vo.getTransaction_id());
				if (StringUtils.isBlank(updateSeril.getChannelUserId())) {
					updateSeril.setChannelUserId(vo.getOpenid());
				}
			}
			// 更新状态
			paymentSerialService.updateSerialPayOrder(updateSeril);
			// 通知业务
			asyncProcessOrderService.sendPaySuccessMsg(serilOrder.getPayOrderId());
			// 通知业务完成后，需要将另外一笔支付单关闭
			processSerilOrder(serilOrder.getPayOrderId(), serilOrder.getPaySerialId(), updateSeril.getStatus());
			return true;
		} catch (Exception e) {
			logger.error("处理微信异步支付回调结果异常", e);
			return false;
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("处理微信异步支付回调结果结束");
			}
		}
	}

	/**
	 *
	 * 支付完成后的后续处理，用异步方式. <br/>
	 *
	 * @param payOrderId
	 * @param paySerilId
	 * @param status
	 */
	private void processSerilOrder(Long payOrderId, Long paySerilId, String status) {
		if (!PaymentConstants.SERIL_STATUS_SUCCESS.equals(status)) {
			return;
		}
		asyncProcessOrderService.closeQrSerilOrders(payOrderId, paySerilId);
	}

	/**
	 *
	 * 支付宝支付回掉接口
	 *
	 * @param paramsMap 回掉的json字符串.
	 * @return
	 */
	public Boolean asyncAlipayResult(Map<String, String> paramsMap) {
		logger.info("处理支付宝异步支付回调结果:{}", JSONObject.toJSONString(paramsMap));
		try {
			if (paramsMap == null) {
				logger.warn("处理支付宝异异步支付回调结果数据为空");
				return false;
			}
			// 获取加密方式 RSA/RSA2
			String charset = paramsMap.get("charset");
			PaymentSerial serilOrder = paymentSerialService.getPaySerilInfoByMerchantOrderId(String.valueOf(paramsMap.get("out_trade_no")));
			if (serilOrder == null) {
				logger.error("处理支付宝异异步支付回调，查询流水信息不存在 ");
				throw new PaymentException(PaymentException.DEFAULT_CODE, "找不到对应的支付订单");
			}
			// 如果已经支付成功，则不再处理
			if (PaymentConstants.SERIL_STATUS_SUCCESS.equals(serilOrder.getStatus())) {
				logger.warn("流水订单：{}，已支付完成，无需再次处理", serilOrder.getPaySerialId());
				return true;
			}
			// 校验支付金额是否和订单金额一致
			if (MoneyCovert.covertFenMoney(paramsMap.get("total_amount")) != serilOrder.getTotalFee()) {
				logger.error("支付金额：{},和通知金额:{},不一致", serilOrder.getTotalFee(),
						paramsMap.get("total_amount"));
				throw new PaymentException(PaymentException.DEFAULT_CODE, "支付金额和通知金额不一致");
			}
			PaymentMerchant merchant = paymentMerchantService.getMerchantInfoByPrimaryKey(serilOrder.getInsideMerchantId());
			logger.info("商户: {}", serilOrder.getInsideMerchantId()+ paramsMap.get("sign_type"));

			Boolean check = AlipaySignature.rsaCheckV1(paramsMap, merchant.getPublicKey(), charset, paramsMap.get("sign_type"));
			if (!check) {
				logger.error("支付宝支付回调结果错误,签名验证失败：{},商户: {}", JSONObject.toJSONString(paramsMap), serilOrder.getInsideMerchantId());
				return check;
			}
			String trade_status = paramsMap.get("trade_status");
			PaymentSerial updateSeril = new PaymentSerial();
			updateSeril.setPaySerialId(serilOrder.getPaySerialId());
			updateSeril.setPayOrderId(serilOrder.getPayOrderId());
			updateSeril.setPayChannel(serilOrder.getPayChannel());
			updateSeril.setPayMode(serilOrder.getPayMode());
			updateSeril.setInsideMerchantId(serilOrder.getInsideMerchantId());
			updateSeril.setMerchantId(serilOrder.getMerchantId());
			if (StringUtils.isBlank(paramsMap.get("trade_no"))
					|| (!StringUtils.equals(trade_status, PaymentConstants.ALIPAY_TRADE_SUCCESS)
					&& !StringUtils.equals(trade_status, PaymentConstants.ALIPAY_TRADE_FINISHED))) {
				logger.error("支付宝支付回调结果错误,支付参数错误：{}", JSONObject.toJSONString(paramsMap));
				// 支付失败后，需要修改订单信息为失败订单
				updateSeril.setStatus(PaymentConstants.SERIL_STATUS_FAILURE);
				paymentSerialService.updateSerialPayOrder(updateSeril);
				return true;
			}
			updateSeril.setStatus(PaymentConstants.SERIL_STATUS_SUCCESS);
			if (StringUtils.isNotBlank(paramsMap.get("gmt_payment"))) {
				updateSeril.setPayedTime(DateTool.getFullDateTime().parse(paramsMap.get("gmt_payment")));
			}
			updateSeril.setTotalFee(MoneyCovert.covertFenMoney(paramsMap.get("total_amount")));
			updateSeril.setAcquireSerialNo(paramsMap.get("trade_no"));
			updateSeril.setExtFields(paramsMap.get("buyer_id") + "|" + paramsMap.get("buyer_logon_id"));
			updateSeril.setChannelUserId(paramsMap.get("open_id"));
			paymentSerialService.updateSerialPayOrder(updateSeril);
			asyncProcessOrderService.sendPaySuccessMsg(serilOrder.getPayOrderId());
			// 关闭另外一笔订单
			processSerilOrder(serilOrder.getPayOrderId(), serilOrder.getPaySerialId(), updateSeril.getStatus());
		} catch (PaymentException e) {
			logger.error("处理支付宝异步支付回调结果业务异常", e);
			return false;
		} catch (Exception e) {
			logger.error("处理支付宝异步支付回调结果异常", e);
			return false;
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("处理支付宝异步支付回调结果结束");
			}
		}
		return true;
	}

	public void sendSuccessOrder(Long payOrderId) {
		asyncProcessOrderService.sendPaySuccessMsg(payOrderId);
	}
}
