package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * * * 退款 * * @author dingqi * @date: 2017年3月26日 上午11:26:06 * @version 1.0
 */
public class RefundResultVo extends BaseResultVo {
    private static final long serialVersionUID = -8546963606974059653L;
    /** 业务订单号 */
    private Long bizOrderId;
    /** * 海鹚业务退款订单号 */
    private Long bizRefundId;
    /** 支付退款单号 */
    private Long payRefundId;
    /** * openId */
    private String openId;
    /** * 渠道唯一ID */
    private String unionId;
    /** * 买家支付宝账号 */
    private String payAccount;
    /** * 退款金额 */
    private Integer refundFee;
    /** 退款医保金额 */
    private Integer refundMedicareFee;
    /** * 退款流水号 */
    private String refundNo;
    /** * 退款受理时间 */
    private Date refundTime;
    /** * 是否已全部退款 */
    private Boolean refundAll;

    /** {@linkplain #refundMedicareFee} */
    public Integer getRefundMedicareFee() {
        return refundMedicareFee;
    }

    /** {@linkplain #refundMedicareFee} */
    public void setRefundMedicareFee(Integer refundMedicareFee) {
        this.refundMedicareFee = refundMedicareFee;
    }

    /** * 获取是否已全部退款 * * @return refundAll 是否已全部退款 */
    public Boolean getRefundAll() {
        return refundAll;
    }

    /** * 设置是否已全部退款 * * @param refundAll 是否已全部退款 */
    public void setRefundAll(Boolean refundAll) {
        this.refundAll = refundAll;
    }

    /** {@linkplain #bizOrderId} */
    public Long getBizOrderId() {
        return bizOrderId;
    }

    /** {@linkplain #bizOrderId} */
    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    /** {@linkplain #bizRefundId} */
    public Long getBizRefundId() {
        return bizRefundId;
    }

    /** {@linkplain #bizRefundId} */
    public void setBizRefundId(Long bizRefundId) {
        this.bizRefundId = bizRefundId;
    }

    /** {@linkplain #payRefundId} */
    public Long getPayRefundId() {
        return payRefundId;
    }

    /** {@linkplain #payRefundId} */
    public void setPayRefundId(Long payRefundId) {
        this.payRefundId = payRefundId;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /** {@linkplain #payAccount} */
    public String getPayAccount() {
        return payAccount;
    }

    /** {@linkplain #payAccount} */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }
}