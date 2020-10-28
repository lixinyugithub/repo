package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 退款参数
 *
 */
public class RefundVo extends BaseParamVo {
    private static final long serialVersionUID = -8546963606974059653L;

    /**
     * 海鹚业务订单号
     */
    private Long orderId;
    
    /** 支付渠道 */
    private String payChannel;

    /** appId */
    private String appId;

    /**
     * 海鹚业务退款订单号
     */
    private Long refundOrderId;

    /** 支付渠道流水 */
    private String acquireSerialNo;
    
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

    private String storeId;
    
    /** 内部商户Id */
    private Long insideMerchantId;

    /** {@linkplain #appId} */
    public String getAppId() {
        return appId;
    }

    /** {@linkplain #appId} */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /** {@linkplain #storeId} */
    public String getStoreId() {
        return storeId;
    }

    /** {@linkplain #storeId} */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
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

    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getInsideMerchantId() {
        return insideMerchantId;
    }

    public void setInsideMerchantId(Long insideMerchantId) {
        this.insideMerchantId = insideMerchantId;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getAcquireSerialNo() {
        return acquireSerialNo;
    }

    public void setAcquireSerialNo(String acquireSerialNo) {
        this.acquireSerialNo = acquireSerialNo;
    }

}