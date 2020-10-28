package com.nbteam.hislite.payment.pay.service;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMode;
import com.nbteam.hislite.payment.pay.mapper.PaymentModeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentModeService
{
	private static final Logger LOG = LoggerFactory.getLogger(PaymentModeService.class);

	@Autowired
	private PaymentModeMapper paymentModeMapper;

	public List<PaymentMode> getModeInfoListByHis(Long hisId, String bizChannel, String bizType, String payMethod, String payChannel) {
		List<PaymentMode> paymentModeList = paymentModeMapper.selectModeInfoList(hisId, bizChannel, bizType, payMethod, payChannel);
		return paymentModeList;
	}

	public PaymentMode getPaymentModeByChannel(String payChannel, String payMethod) {
		return paymentModeMapper.getPaymentModeByChannel(payChannel, payMethod);
	}
}
