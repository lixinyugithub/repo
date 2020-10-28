package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 订单关闭vo
 *
 */
public class ClosePayOrderParamVo extends BaseParamVo {
    private static final long serialVersionUID = 1L;
    /**
     * 业务订单号 
     */
    private Long bizOrderId;
    
    /**
     * 支付订单号 
     */
    private Long payOrderId;

    /**
     * 渠道来源
     */
    private String platformSource;


    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public String getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(String platformSource) {
        this.platformSource = platformSource;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }
}
