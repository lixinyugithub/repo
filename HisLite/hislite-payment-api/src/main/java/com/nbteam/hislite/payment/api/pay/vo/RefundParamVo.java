package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 退款参数
 *
 */
public class RefundParamVo extends BaseParamVo {
    private static final long serialVersionUID = -8546963606974059653L;

    /**
     * 海鹚业务订单号
     */
    private Long bizOrderId;

    /**
     * 海鹚业务退款订单号
     */
    private Long bizRefundId;

    /** 业务渠道来源 {@link com.gzhc365.common.enums.PlatformSourceEnum} */
    private String bizChannel;
    /** 业务类型 {@link com.gzhc365.common.enums.BizTypeEnum} */
    private String bizType;

    /**
     * 医院退款单号
     */
    private String hisRefundNo;
    /**
     * 退款金额
     */
    private Integer refundFee;

    /**
     * 退款标志 1：医院返回明确失败时，自动退款 2：患者主动取消时退款 3：超出支付时间的退款 4：人工发起的退款 5：医生停诊退款
     * 6：超时未报到退款 7：调用接口退款
     */
    private String flag;

    /**
     * 退款原因 最多100个字
     */
    private String reason;

    /**
     * 第三方授权token
     */
    private String appAuthToken;

    /**
     * 商户的终端编号
     */
    private String terminalId;

    /**
     * 商户的操作员编号
     */
    private String operatorId;

    /** {@linkplain #bizChannel} */
    public String getBizChannel() {
        return bizChannel;
    }

    /** {@linkplain #bizChannel} */
    public void setBizChannel(String bizChannel) {
        this.bizChannel = bizChannel;
    }

    /** {@linkplain #bizType} */
    public String getBizType() {
        return bizType;
    }

    /** {@linkplain #bizType} */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    /** {@linkplain #hisRefundNo} */
    public String getHisRefundNo() {
        return hisRefundNo;
    }

    /** {@linkplain #hisRefundNo} */
    public void setHisRefundNo(String hisRefundNo) {
        this.hisRefundNo = hisRefundNo;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
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

}