package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 查询支付订单 去支付中心查询订单必须有支付订单号
 * 
 */
public class PayQueryParamVo extends BaseParamVo {
    private static final long serialVersionUID = 3367394462283818393L;
    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 支付订单号
     */
    private Long payOrderId;

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
}