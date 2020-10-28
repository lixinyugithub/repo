package com.nbteam.hislite.payment.pay.service;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchant;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMode;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import com.nbteam.hislite.payment.pay.mapper.PaymentMerchantMapper;
import com.nbteam.hislite.payment.pay.mapper.PaymentModeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMerchantService
{
	private static final Logger logger = LoggerFactory.getLogger(PaymentMerchantService.class);

	@Autowired
	private PaymentMerchantMapper paymentMerchantMapper;

	@Autowired
	private PaymentModeMapper paymentModeMapper;

	public PaymentMerchant getMerchantInfoByHisCondition(Long hisId, String bizType, String bizChannel, String payChannel, String payMethod) {
		PaymentMode paymentMode = paymentModeMapper.getPaymentModeByChannel(payChannel, payMethod);
		if (paymentMode == null) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式为空");
		}
		PaymentMerchant paymentMerchant = paymentMerchantMapper.getPaymentMerchantByMode(hisId, bizChannel, bizType, paymentMode.getPayMode());
		if (paymentMerchant == null) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式和商户信息关联不存在");
		}
		return paymentMerchant;
	}

	public PaymentMerchant getMerchantInfoByHisCondition(Long hisId, String bizType, String bizChannel, String payMode) {
		PaymentMode paymentMode = paymentModeMapper.selectByPrimaryKey(payMode);
		if (paymentMode == null) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式为空");
		}
		PaymentMerchant paymentMerchant = paymentMerchantMapper.getPaymentMerchantByMode(hisId, bizChannel, bizType, paymentMode.getPayMode());
		if (paymentMerchant == null) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式和商户信息关联不存在");
		}
		return paymentMerchant;
	}

	public PaymentMerchant getMerchantInfoByPrimaryKey(Long insideMerchantId) {
		return paymentMerchantMapper.selectByPrimaryKey(insideMerchantId);
	}
}
