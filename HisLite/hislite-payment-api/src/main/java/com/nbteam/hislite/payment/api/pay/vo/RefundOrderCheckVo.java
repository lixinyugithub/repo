package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 退款单状态查询返回数据<br/>
 *
 */
public class RefundOrderCheckVo extends BaseResultVo {

    /** 
     */
    private static final long serialVersionUID = 5929569834950748992L;
    /** 支付商户订单号 */
    private String merchantOrderId;
    /** 支付渠道流水 */
    private String acquireSerialNo;
    /** 退款申请总额 */
    private Integer refundTotalFee = 0;
    /** 实际退款金额 */
    private Integer RealRefundFee = 0;
    /** 退款笔数 */
    private Integer refundCount = 0;
    /** 退款单号 */
    private Long refundOrderId;
    /** 退款成功时间 */
    private Date refundSuccessTime;
    /** 退款状态 */
    private String refundStatus;
    /** 微信退款流水号 */
    private String wxRefundId;
    /**
     * 退款原因 最多100个字
     */
    private String reason;

    /** {@linkplain #wxRefundId} */
    public String getWxRefundId() {
        return wxRefundId;
    }

    /** {@linkplain #wxRefundId} */
    public void setWxRefundId(String wxRefundId) {
        this.wxRefundId = wxRefundId;
    }

    /** {@linkplain #refundStatus} */
    public String getRefundStatus() {
        return refundStatus;
    }

    /** {@linkplain #refundStatus} */
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    /** {@linkplain #merchantOrderId} */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /** {@linkplain #merchantOrderId} */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    /** {@linkplain #acquireSerialNo} */
    public String getAcquireSerialNo() {
        return acquireSerialNo;
    }

    /** {@linkplain #acquireSerialNo} */
    public void setAcquireSerialNo(String acquireSerialNo) {
        this.acquireSerialNo = acquireSerialNo;
    }

    /** {@linkplain #refundTotalFee} */
    public Integer getRefundTotalFee() {
        return refundTotalFee;
    }

    /** {@linkplain #refundTotalFee} */
    public void setRefundTotalFee(Integer refundTotalFee) {
        this.refundTotalFee = refundTotalFee;
    }

    /** {@linkplain #RealRefundFee} */
    public Integer getRealRefundFee() {
        return RealRefundFee;
    }

    /** {@linkplain #RealRefundFee} */
    public void setRealRefundFee(Integer realRefundFee) {
        RealRefundFee = realRefundFee;
    }

    /** {@linkplain #refundCount} */
    public Integer getRefundCount() {
        return refundCount;
    }

    /** {@linkplain #refundCount} */
    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    /** {@linkplain #refundOrderId} */
    public Long getRefundOrderId() {
        return refundOrderId;
    }

    /** {@linkplain #refundOrderId} */
    public void setRefundOrderId(Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    /** {@linkplain #refundSuccessTime} */
    public Date getRefundSuccessTime() {
        return refundSuccessTime;
    }

    /** {@linkplain #refundSuccessTime} */
    public void setRefundSuccessTime(Date refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
