package com.nbteam.hislite.payment.api.pay.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 
 */
public class PaymentMethodKey implements Serializable {
    @ApiModelProperty("支付方法(wap-wap支付，app-app支付，qr-扫码付，f2f-扫码付，medicareOnline-在线医保支付，prepaidCard-预付卡支付，zero-零元支付，credit-信用卡支付，withhod-代扣支付)")
    private String payMethod;

    @ApiModelProperty("支付渠道(channel_info主键)")
    private String payChannel;

    private static final long serialVersionUID = 1L;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }
}