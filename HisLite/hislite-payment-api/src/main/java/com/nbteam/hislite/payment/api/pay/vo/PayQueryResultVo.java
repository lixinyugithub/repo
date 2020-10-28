package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 订单查询结果
 *
 */
public class PayQueryResultVo extends BaseResultVo {
    private static final long serialVersionUID = 1L;
    /**
     * 业务订单号 必填
     */
    private Long bizOrderId;
    /**
     * 支付订单号
     */
    private Long payOrderId;
    /**
     * 支付金额
     */
    private Integer totalFee;
    /**
     * 支付宝交易流水号
     */
    private String acquireSerialNo;
    /**
     * openId
     */
    private String openId;
    /**
     * 支付时间
     */
    private Date payedTime;

    /**
     * 支付方式
     */
    private String payChannel;

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    /** {@linkplain #totalFee} */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** {@linkplain #totalFee} */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** {@linkplain #acquireSerialNo} */
    public String getAcquireSerialNo() {
        return acquireSerialNo;
    }

    /** {@linkplain #acquireSerialNo} */
    public void setAcquireSerialNo(String acquireSerialNo) {
        this.acquireSerialNo = acquireSerialNo;
    }

    /** {@linkplain #payedTime} */
    public Date getPayedTime() {
        return payedTime;
    }

    /** {@linkplain #payedTime} */
    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    /** {@linkplain #payChannel} */
    public String getPayChannel() {
        return payChannel;
    }

    /** {@linkplain #payChannel} */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

}
