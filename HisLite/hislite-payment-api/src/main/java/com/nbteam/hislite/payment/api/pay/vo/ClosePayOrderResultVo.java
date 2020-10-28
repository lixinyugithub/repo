package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 订单关闭返回对象<br/>
 *
 */
public class ClosePayOrderResultVo extends BaseResultVo {

    /** 
     */  
    private static final long serialVersionUID = 892465732852251277L;

    /**
     * 业务订单号 
     */
    private Long bizOrderId; 
    /**
     * 支付订单号 
     */
    private Long payOrderId;

    /**
     * 关闭时间
     */
    private Date closeTime;

    /**
     * 金额
     */
    private Integer payAmout;

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public Integer getPayAmout() {
        return payAmout;
    }

    public void setPayAmout(Integer payAmout) {
        this.payAmout = payAmout;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
