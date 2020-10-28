package com.nbteam.hislite.payment.pay.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import com.nbteam.hislite.payment.api.pay.dto.PaymentOrder;
import com.nbteam.hislite.payment.api.pay.dto.PaymentSerial;
import com.nbteam.hislite.payment.pay.mapper.PaymentOrderMapper;
import com.nbteam.hislite.payment.pay.mapper.PaymentSerialMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentSerialService
{
	private static final Logger logger = LoggerFactory.getLogger(PaymentSerialService.class);

	@Autowired
	private PaymentSerialMapper paymentSerialMapper;

	@Autowired
	private PaymentOrderMapper paymentOrderMapper;


	public PaymentSerial generatorPaySerialInfo(PaymentOrder order) {
		PaymentSerial paymentSerial = new PaymentSerial();
		BeanUtils.copyProperties(order, paymentSerial);
		paymentSerialMapper.insertSelective(paymentSerial);
		return paymentSerial;
	}

    public void update(PaymentSerial updateSeril) {
		paymentSerialMapper.updateByPrimaryKeySelective(updateSeril);
    }

	public Integer updatePayOrderAndSerilInfo(PaymentSerial info, PaymentOrder order) {
		if (logger.isDebugEnabled()) {
			logger.debug("更新支付流水信息:serilInfo:{}, pay:{}", JSONObject.toJSONString(info),
					JSONObject.toJSONString(order));
		}
		int count = 0;
		if (info != null) {
			count = paymentSerialMapper.updateByPrimaryKeySelective(info);
		}
		// 扫码支付不更新订单表，因为不知道用户会扫哪一个二维码支付订单
//		if (order != null && !PaymentConstants.PAY_METHOD_QR.equals(info.getPayMethod())) {
		if (order != null) {
			count = paymentOrderMapper.updateByPrimaryKeySelective(order);
		}
		return count;
	}

	public PaymentSerial getPaySerilInfoByMerchantOrderId(String merchantOrderId) {
		if (logger.isDebugEnabled()) {
			logger.debug("根据商户订单号查询支付流水信息：{}",  merchantOrderId);
		}
		if (merchantOrderId == null) {
			logger.warn("根据商户订单号查询支付流水信息参数为空");
			return null;
		}
		return paymentSerialMapper.selectByMerchantOrderId(merchantOrderId);
	}

	@Transactional
	public PaymentSerial updateSerialPayOrder(PaymentSerial t) {
		if (logger.isDebugEnabled()) {
			logger.debug("更新支付流水{}", JSON.toJSON(t));
		}
		if (null == t || null == t.getPayOrderId()) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付订单号不能为空");
		}
		if (null == t || null == t.getPaySerialId()) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付流水号不能为空");
		}

		PaymentOrder payOrder = paymentOrderMapper.selectByPrimaryKey(t.getPayOrderId());
		if (null == payOrder) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "未知支付订单");
		}
		if (paymentSerialMapper.updateByPrimaryKeySelective(t) > 0) {
			logger.info("更新支付流水成功, 支付流水{}", JSON.toJSON(t));
		} else {
			logger.error("更新支付流水失败, 支付流水{}", JSON.toJSON(t));
			throw new PaymentException(PaymentException.DEFAULT_CODE, "更新支付流水失败");
		}
		// 只有支付成功的才更改主订单状态
		if (PaymentConstants.SERIL_STATUS_SUCCESS.equals(t.getStatus())) {
			payOrder.setStatus(t.getStatus());
			payOrder.setChannelUserId(t.getChannelUserId());
			payOrder.setAcquirerSerialNo(t.getAcquireSerialNo());
			payOrder.setPaySerialNo(t.getPaySerialId());
			payOrder.setPayChannel(t.getPayChannel());
			payOrder.setPayMode(t.getPayMode());
			payOrder.setPayMethod(t.getPayMethod());
			payOrder.setInsideMerchantId(t.getInsideMerchantId());
			payOrder.setPayedTime(t.getPayedTime());
			payOrder.setPrePayNo(t.getPrePayNo());
			payOrder.setMerchantId(t.getMerchantId());
			payOrder.setMerchantOrderId(t.getMerchantOrderId());
			payOrder.setFee(t.getFee());
			payOrder.setBank(t.getBank());
			payOrder.setTotalFee(t.getTotalFee());
			payOrder.setRealTotalFee(t.getTotalFee());
			if (paymentOrderMapper.updateByPrimaryKeySelective(payOrder) > 0) {
				logger.info("更新支付订单成功, 支付订单{}", JSON.toJSON(t));
			} else {
				logger.error("更新支付订单失败, 支付流水{}", JSON.toJSON(t));
				throw new PaymentException(PaymentException.DEFAULT_CODE, "更新支付订单失败");
			}
		}
		return t;
	}

    public List<PaymentSerial> getSerialOrdersByPayId(Long payOrderId) {
		if (logger.isDebugEnabled()) {
			logger.debug("通过支付id获取支付订单流水列表， payOrderId：{}", payOrderId);
		}
		return paymentSerialMapper.selectByPayOrderId(payOrderId);
    }
}
