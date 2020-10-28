package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 当面付撤销入参
 *
 */
public class F2FPayRevokeParamVo extends BaseParamVo {
    private static final long serialVersionUID = 1L;
    /**
     * 业务订单号
     */
    private Long bizOrderId;

    /**
     * 支付订单号
     */
    private Long payOrderId;

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }
}
