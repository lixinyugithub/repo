package com.nbteam.hislite.payment.api.pay.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 
 */
public class PaymentBizModeRelaKey implements Serializable {
    @ApiModelProperty("医院id")
    private Long hisId;

    @ApiModelProperty("业务渠道来源")
    private String bizChannel;

    @ApiModelProperty("支付模式")
    private String payMode;

    @ApiModelProperty("业务类型")
    private String bizType;

    private static final long serialVersionUID = 1L;

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

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}