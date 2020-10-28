package com.nbteam.hislite.payment.api.pay.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 
 * 统一下单支付<br/>
 *
 */
public class ChooseModeParamVo extends BaseParamVo {

    /** 
     */
    private static final long serialVersionUID = -423554011707381191L;
    /** 平台ID */
    @NotNull(message="平台ID不能为空")
    private Long platformId;
    /** 支付订单号 */
    @NotNull(message="支付订单号不能为空")
    private Long payOrderId;
    /** 支付方式 */
    private String payMode;
    /** 支付方法 */
    private String payMethod;
    /** 支付渠道 */
    private String payChannel;
    /** ip地址 */
    private String ipAddress;
    /** 内部商户号 */
    private Long insideMerchantId;
    /** 支付回调地址 */
    private String returnUrl;
    /** 医院订单号 */
    private String hisOrderNo;
    /** 门诊批次号 */
    private String hisBillNo;

    /** {@linkplain #returnUrl} */
    public String getReturnUrl() {
        return returnUrl;
    }

    /** {@linkplain #returnUrl} */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    /** {@linkplain #platformId} */
    public Long getPlatformId() {
        return platformId;
    }

    /** {@linkplain #platformId} */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /** {@linkplain #insideMerchantId} */
    public Long getInsideMerchantId() {
        return insideMerchantId;
    }

    /** {@linkplain #insideMerchantId} */
    public void setInsideMerchantId(Long insideMerchantId) {
        this.insideMerchantId = insideMerchantId;
    }

    /** {@linkplain #ipAddress} */
    public String getIpAddress() {
        return ipAddress;
    }

    /** {@linkplain #ipAddress} */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /** {@linkplain #payMode} */
    public String getPayMode() {
        return payMode;
    }

    /** {@linkplain #payMode} */
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    /** {@linkplain #payChannel} */
    public String getPayChannel() {
        return payChannel;
    }

    /** {@linkplain #payChannel} */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    /** {@linkplain #payOrderId} */
    public Long getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    /** {@linkplain #payMethod} */
    public String getPayMethod() {
        return payMethod;
    }

    /** {@linkplain #payMethod} */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

	public String getHisOrderNo() {
		return hisOrderNo;
	}

	public void setHisOrderNo(String hisOrderNo) {
		this.hisOrderNo = hisOrderNo;
	}

	public String getHisBillNo() {
		return hisBillNo;
	}

	public void setHisBillNo(String hisBillNo) {
		this.hisBillNo = hisBillNo;
	}


}
