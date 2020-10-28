package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 支付订单扩展<br/>
 *
 */
public class PayOrderInfoVo implements Serializable {
    /** 支付订单号 */
    private Long payOrderId;

    /** 业务订单号 */
    private Long bizOrderId;

    /** 医院id */
    private Long hisId;

    /** 医院名称 */
    private String hisName;

    /** 业务平台来源 */
    private String bizChannel;

    /** 业务类型 */
    private String bizType;

    /** 支付模式 */
    private String payMode;

    /** 支付渠道 */
    private String payChannel;

    /** 支付方法 */
    private String payMethod;

    /** 用户渠道id */
    private String channelUserId;

    /** 用户Id */
    private Long userId;

    /** 商品名称 */
    private String goodsName;

    /** 订单金额 */
    private Integer totalFee;

    /** 现金金额 */
    private Integer fee;

    /** 医保报销金额 */
    private Integer medicareFee;

    /** 优惠金额 */
    private Integer discountFee;

    /** 实际支付金额 */
    private Integer realTotalFee;

    /** 支付时长(分钟) */
    private Integer effectiveLength;

    /** 状态（U-预登记 S-成功 I-未知 F-失败 O-已撤销） */
    private String status;

    /** 支付流水号 */
    private Long paySerialNo;

    /** 内部商户Id */
    private Long insideMerchantId;

    /** 商户号Id */
    private String merchantId;

    /** 支付渠道商户订单号 */
    private String merchantOrderId;

    /** 预支付Id */
    private String prePayNo;

    /** 支付时间 */
    private Date payedTime;

    /** 支付流水号 */
    private String acquirerSerialNo;

    /** 支付银行 */
    private String bank;

    /** 支付银行流水 */
    private String bankSerial;

    /** 扩展字段 */
    private String extFields;
    /** 业务内容 */
    private String bizContent;

    /** 是否仅支持医保支付 */
    private Integer isMedPay;

    /** 撤销操作时间 */
    private Date revokeTime;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /** {@linkplain #bizContent} */
    public String getBizContent() {
        return bizContent;
    }

    /** {@linkplain #bizContent} */
    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    /** {@linkplain #isMedPay} */
    public Integer getIsMedPay() {
        return isMedPay;
    }

    /** {@linkplain #isMedPay} */
    public void setIsMedPay(Integer isMedPay) {
        this.isMedPay = isMedPay;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    /** {@linkplain #bizChannel} */
    public String getBizChannel() {
        return bizChannel;
    }

    /** {@linkplain #bizChannel} */
    public void setBizChannel(String bizChannel) {
        this.bizChannel = bizChannel;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    /** {@linkplain #payMethod} */
    public String getPayMethod() {
        return payMethod;
    }

    /** {@linkplain #payMethod} */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId == null ? null : channelUserId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getMedicareFee() {
        return medicareFee;
    }

    public void setMedicareFee(Integer medicareFee) {
        this.medicareFee = medicareFee;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
    }

    public Integer getRealTotalFee() {
        return realTotalFee;
    }

    public void setRealTotalFee(Integer realTotalFee) {
        this.realTotalFee = realTotalFee;
    }

    public Integer getEffectiveLength() {
        return effectiveLength;
    }

    public void setEffectiveLength(Integer effectiveLength) {
        this.effectiveLength = effectiveLength;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getPaySerialNo() {
        return paySerialNo;
    }

    public void setPaySerialNo(Long paySerialNo) {
        this.paySerialNo = paySerialNo;
    }

    public Long getInsideMerchantId() {
        return insideMerchantId;
    }

    public void setInsideMerchantId(Long insideMerchantId) {
        this.insideMerchantId = insideMerchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId == null ? null : merchantOrderId.trim();
    }

    public String getPrePayNo() {
        return prePayNo;
    }

    public void setPrePayNo(String prePayNo) {
        this.prePayNo = prePayNo == null ? null : prePayNo.trim();
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public String getAcquirerSerialNo() {
        return acquirerSerialNo;
    }

    public void setAcquirerSerialNo(String acquirerSerialNo) {
        this.acquirerSerialNo = acquirerSerialNo == null ? null : acquirerSerialNo.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankSerial() {
        return bankSerial;
    }

    public void setBankSerial(String bankSerial) {
        this.bankSerial = bankSerial == null ? null : bankSerial.trim();
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields == null ? null : extFields.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }
}