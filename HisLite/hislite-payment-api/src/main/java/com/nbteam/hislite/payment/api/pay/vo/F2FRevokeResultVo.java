package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 当面付撤销返回结果<br/>
 *
 */
public class F2FRevokeResultVo extends BaseResultVo {
    private static final long serialVersionUID = -3979372909770074515L;
    /**
     * 业务订单号
     */
    private Long bizOrderId;
    /**
     * 支付订单号
     */
    private Long payOrderId;

    /**
     * 撤销状态 -1：撤销失败 0：撤销成功
     */
    private String revokeStatus;
    /**
     * 撤销状态说明
     */
    private String revokeStatusDes;
    /**
     * 撤销时间
     */
    private Date revokeTime;

    /**
     * 金额
     */
    private Integer payFee;

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public String getRevokeStatus() {
        return revokeStatus;
    }

    public void setRevokeStatus(String revokeStatus) {
        this.revokeStatus = revokeStatus;
    }

    public String getRevokeStatusDes() {
        return revokeStatusDes;
    }

    public void setRevokeStatusDes(String revokeStatusDes) {
        this.revokeStatusDes = revokeStatusDes;
    }

    public Date getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }

    /** {@linkplain #payFee} */
    public Integer getPayFee() {
        return payFee;
    }

    /** {@linkplain #payFee} */
    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }
}
