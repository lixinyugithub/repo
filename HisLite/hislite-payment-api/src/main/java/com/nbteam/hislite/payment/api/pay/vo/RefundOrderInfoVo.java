package com.nbteam.hislite.payment.api.pay.vo;

import java.util.Date;

/**
 * 
 * 退款单包装类<br/>
 *
 */
public class RefundOrderInfoVo extends BaseParamVo {
    /** 
     */
    private static final long serialVersionUID = -2990967472395879651L;

    /** 退款订单号 */
    private Long refundOrderId;

    /** 业务退款订单号 */
    private Long bizRefundOrderId;

    /** 支付流水号 */
    private Long paySerialId;

    /** 支付订单号 */
    private Long payOrderId;

    /** 业务订单号 */
    private Long bizOrderId;
    /** 业务类型 */
    private String bizType;

    /** 支付方式 */
    private String payMode;

    /** 支付渠道 */
    private String payChannel;

    /** 支付方法 */
    private String payMethod;

    /** 状态（U-预登记 W-退款处理中 S-成功 F-失败） */
    private String status;

    /** 退款金额 */
    private Integer refundFee;

    /** 内部商户ID */
    private Long insideMerchantId;

    /** 商户号 */
    private String merchantId;

    /** 商户订单号 */
    private String merchantOrderId;

    /** 退款时间 */
    private Date refundTime;

    /** 退款渠道流水 */
    private String acquirerSerialNo;

    /** 退款到的银行名称 */
    private String bank;

    /** 退款银行流水 */
    private String bankSerialNo;

    /** 扩展字段 */
    private String extFields;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

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
     * 商户的终端编号
     */
    private String terminalId;

    /**
     * 商户的操作员编号
     */
    private String operatorId;

    private String storeId;

    /********************* 以下为补充字段 *************************/
    /** 订单总金额 */
    private Integer totalFee;
    /** 是否全额退款 */
    private Boolean refundAll;
    /** 是否医保支付 */
    private Integer isMedPay;

    /** {@linkplain #isMedPay} */
    public Integer getIsMedPay() {
        return isMedPay;
    }

    /** {@linkplain #isMedPay} */
    public void setIsMedPay(Integer isMedPay) {
        this.isMedPay = isMedPay;
    }

    /** {@linkplain #bizType} */
    public String getBizType() {
        return bizType;
    }

    /** {@linkplain #bizType} */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /** 支付渠道流水 */
    private String payAcquirerSerialNo;

    public String getPayAcquirerSerialNo() {
        return payAcquirerSerialNo;
    }

    /** {@linkplain #payAcquirerSerialNo} */
    public void setPayAcquirerSerialNo(String payAcquirerSerialNo) {
        this.payAcquirerSerialNo = payAcquirerSerialNo;
    }

    /** {@linkplain #refundAll} */
    public Boolean getRefundAll() {
        return refundAll;
    }

    /** {@linkplain #refundAll} */
    public void setRefundAll(Boolean refundAll) {
        this.refundAll = refundAll;
    }

    /** {@linkplain #totalFee} */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** {@linkplain #totalFee} */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** {@linkplain #refundOrderId} */
    public Long getRefundOrderId() {
        return refundOrderId;
    }

    /** {@linkplain #refundOrderId} */
    public void setRefundOrderId(Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    /** {@linkplain #bizRefundOrderId} */
    public Long getBizRefundOrderId() {
        return bizRefundOrderId;
    }

    /** {@linkplain #bizRefundOrderId} */
    public void setBizRefundOrderId(Long bizRefundOrderId) {
        this.bizRefundOrderId = bizRefundOrderId;
    }

    /** {@linkplain #paySerialId} */
    public Long getPaySerialId() {
        return paySerialId;
    }

    /** {@linkplain #paySerialId} */
    public void setPaySerialId(Long paySerialId) {
        this.paySerialId = paySerialId;
    }

    /** {@linkplain #payOrderId} */
    public Long getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    /** {@linkplain #bizOrderId} */
    public Long getBizOrderId() {
        return bizOrderId;
    }

    /** {@linkplain #bizOrderId} */
    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    /** {@linkplain #payMode} */
    public String getPayMode() {
        return payMode;
    }

    /** {@linkplain #payMode} */
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    /** {@linkplain #payChannel} */
    public String getPayChannel() {
        return payChannel;
    }

    /** {@linkplain #payChannel} */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    /** {@linkplain #payMethod} */
    public String getPayMethod() {
        return payMethod;
    }

    /** {@linkplain #payMethod} */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /** {@linkplain #status} */
    public String getStatus() {
        return status;
    }

    /** {@linkplain #status} */
    public void setStatus(String status) {
        this.status = status;
    }

    /** {@linkplain #refundFee} */
    public Integer getRefundFee() {
        return refundFee;
    }

    /** {@linkplain #refundFee} */
    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    /** {@linkplain #insideMerchantId} */
    public Long getInsideMerchantId() {
        return insideMerchantId;
    }

    /** {@linkplain #insideMerchantId} */
    public void setInsideMerchantId(Long insideMerchantId) {
        this.insideMerchantId = insideMerchantId;
    }

    /** {@linkplain #merchantId} */
    public String getMerchantId() {
        return merchantId;
    }

    /** {@linkplain #merchantId} */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /** {@linkplain #merchantOrderId} */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /** {@linkplain #merchantOrderId} */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    /** {@linkplain #refundTime} */
    public Date getRefundTime() {
        return refundTime;
    }

    /** {@linkplain #refundTime} */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /** {@linkplain #acquirerSerialNo} */
    public String getAcquirerSerialNo() {
        return acquirerSerialNo;
    }

    /** {@linkplain #acquirerSerialNo} */
    public void setAcquirerSerialNo(String acquirerSerialNo) {
        this.acquirerSerialNo = acquirerSerialNo;
    }

    /** {@linkplain #bank} */
    public String getBank() {
        return bank;
    }

    /** {@linkplain #bank} */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /** {@linkplain #bankSerialNo} */
    public String getBankSerialNo() {
        return bankSerialNo;
    }

    /** {@linkplain #bankSerialNo} */
    public void setBankSerialNo(String bankSerialNo) {
        this.bankSerialNo = bankSerialNo;
    }

    /** {@linkplain #extFields} */
    public String getExtFields() {
        return extFields;
    }

    /** {@linkplain #extFields} */
    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    /** {@linkplain #createTime} */
    public Date getCreateTime() {
        return createTime;
    }

    /** {@linkplain #createTime} */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** {@linkplain #updateTime} */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** {@linkplain #updateTime} */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

}
