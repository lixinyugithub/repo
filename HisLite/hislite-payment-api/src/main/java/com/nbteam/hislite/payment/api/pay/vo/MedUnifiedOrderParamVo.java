package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 医保支付统一下单参数<br/>
 *
 */
public class MedUnifiedOrderParamVo extends BaseParamVo {

    /** 
     */
    private static final long serialVersionUID = -3513036012984804595L;
    /** 支付订单号 */
    private Long payOrderId;
    /** 支付方式 */
    private String payMode;
    /** 支付渠道 */
    private String payChannel;
    /** 支付方法 */
    private String payMethod;
    /** ip地址 */
    private String ipAddress;

    /** {@linkplain #payOrderId} */
    public Long getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
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

    /** {@linkplain #payMethod} */
    public String getPayMethod() {
        return payMethod;
    }

    /** {@linkplain #payMethod} */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /** {@linkplain #ipAddress} */
    public String getIpAddress() {
        return ipAddress;
    }

    /** {@linkplain #ipAddress} */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
