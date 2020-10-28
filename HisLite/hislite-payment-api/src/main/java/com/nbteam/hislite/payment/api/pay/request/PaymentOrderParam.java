package com.nbteam.hislite.payment.api.pay.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 订单查询参数
 */
public class PaymentOrderParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8520801160986538799L;

	@ApiModelProperty("医院id")
	private Long hisId;

	@ApiModelProperty(" 业务平台来源")
	private String bizChannel;

	@ApiModelProperty("业务订单号")
	private Long bizOrderId;

	@ApiModelProperty("业务类型")
	private String bizType;

	/** 支付订单号 */
	@ApiModelProperty("支付订单号")
	private Long payOrderId;

	/** 支付模式 */
	@ApiModelProperty("支付模式")
	private String payMode;

	/** 支付渠道 */
	@ApiModelProperty("支付渠道")
	private String payChannel;

	/** 支付方法 */
	@ApiModelProperty("支付方法")
	private String payMethod;

	public Long getHisId() {
		return hisId;
	}

	public void setHisId(Long hisId) {
		this.hisId = hisId;
	}

	public String getBizChannel() {
		return bizChannel;
	}

	public void setBizChannel(String bizChannel) {
		this.bizChannel = bizChannel;
	}

	public Long getBizOrderId() {
		return bizOrderId;
	}

	public void setBizOrderId(Long bizOrderId) {
		this.bizOrderId = bizOrderId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public Long getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(Long payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

}