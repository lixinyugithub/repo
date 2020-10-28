package com.nbteam.hislite.payment.pay.service;


import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.pay.vo.*;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import org.apache.commons.lang3.StringUtils;

/***
 *
 */
public abstract class IPayServiceHandler {

	public F2FPayVo f2fPay(PaySerialVo vo) {
		return null;
	}

	public PayQueryVo orderQuery(PaySerialVo vo) {
		return null;
	}

	public F2FRevokeVo revoke(PaySerialVo vo) {
		return null;
	}

	public UnifiedOrderVo unifiedOrder(PaySerialVo vo) {
		return null;
	}

	public RefundResultVo refundOrder(RefundOrderInfoVo vo) {
		return null;
	}

	public RefundOrderCheckVo checkRefundOrderStatus(RefundOrderInfoVo refundOrder) {
		return null;
	}

	public ClosePayOrderVo closePayOrder(PaySerialVo vo) {
		return null;
	}

	protected String getTradeType(String payMethod) {
		if (StringUtils.isBlank(payMethod)) {
			return null;
		}
		switch (payMethod) {
			case PaymentConstants.PAY_METHOD_WAP:
				return "JSAPI";
			case PaymentConstants.PAY_METHOD_QR:
				return "NATIVE";
			case PaymentConstants.PAY_METHOD_APP:
				return "APP";
			default:
				break;
		}
		return null;
	}

	/**
	 *
	 * 判断是否使用信用卡. <br/>
	 *
	 * @version 1.0
	 *
	 * @param switchs
	 * @return
	 */
	protected static String checkUserCredit(String switchs) {
		if (StringUtils.isBlank(switchs) || switchs.length() != 10 || !StringUtils.isNumeric(switchs)) {
			throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "INVALID_PARAM");
		}
		if (PaymentConstants.NO.equals(switchs.substring(0, 1))) {
			return "no_credit";
		}
		return null;
	}
}
