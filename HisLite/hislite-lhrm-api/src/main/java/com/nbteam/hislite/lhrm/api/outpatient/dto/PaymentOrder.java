package com.nbteam.hislite.lhrm.api.outpatient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class PaymentOrder implements Serializable {
    @ApiModelProperty("支付订单号")
    private Long payOrderId;

    @ApiModelProperty("业务订单号")
    private Long bizOrderId;

    @ApiModelProperty("医院id")
    private Long hisId;

    @ApiModelProperty("医院名称")
    private String hisName;

    @ApiModelProperty(" 业务平台来源")
    private String bizChannel;

    @ApiModelProperty("业务类型")
    private String bizType;

    @ApiModelProperty("支付模式")
    private String payMode;

    @ApiModelProperty("支付渠道")
    private String payChannel;

    @ApiModelProperty("支付方法")
    private String payMethod;

    @ApiModelProperty("用户渠道id")
    private String channelUserId;

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("订单金额")
    private Integer totalFee;

    @ApiModelProperty("现金金额")
    private Integer fee;

    @ApiModelProperty("医保报销金额")
    private Integer medicareFee;

    @ApiModelProperty("优惠金额")
    private Integer discountFee;

    @ApiModelProperty("实际支付金额")
    private Integer realTotalFee;

    @ApiModelProperty("支付时长(分钟)")
    private Integer effectiveLength;

    @ApiModelProperty("状态（U-预登记 S-成功 I-未知 F-失败 O-已撤销）")
    private String status;

    @ApiModelProperty("支付流水号")
    private Long paySerialNo;

    @ApiModelProperty("内部商户Id")
    private Long insideMerchantId;

    @ApiModelProperty("商户号Id")
    private String merchantId;

    @ApiModelProperty("支付渠道商户订单号")
    private String merchantOrderId;

    @ApiModelProperty("预支付Id")
    private String prePayNo;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    @ApiModelProperty("支付流水号")
    private String acquirerSerialNo;

    @ApiModelProperty("支付银行")
    private String bank;

    @ApiModelProperty("支付银行流水")
    private String bankSerial;

    @ApiModelProperty("业务传过来的内容")
    private String bizContent;

    @ApiModelProperty("是否只能医保支付（1-是 0-否）")
    private Integer isMedPay;

    @ApiModelProperty("通知业务标志（0-未通知 1-已通知）")
    private Integer noticeBizFlag;

    @ApiModelProperty("扩展字段")
    private String extFields;

    @ApiModelProperty("撤销,关闭,操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date revokeTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

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

    public String getBizChannel() {
        return bizChannel;
    }

    public void setBizChannel(String bizChannel) {
        this.bizChannel = bizChannel;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
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
        this.goodsName = goodsName;
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
        this.status = status;
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
        this.merchantId = merchantId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getPrePayNo() {
        return prePayNo;
    }

    public void setPrePayNo(String prePayNo) {
        this.prePayNo = prePayNo;
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
        this.acquirerSerialNo = acquirerSerialNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankSerial() {
        return bankSerial;
    }

    public void setBankSerial(String bankSerial) {
        this.bankSerial = bankSerial;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public Integer getIsMedPay() {
        return isMedPay;
    }

    public void setIsMedPay(Integer isMedPay) {
        this.isMedPay = isMedPay;
    }

    public Integer getNoticeBizFlag() {
        return noticeBizFlag;
    }

    public void setNoticeBizFlag(Integer noticeBizFlag) {
        this.noticeBizFlag = noticeBizFlag;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public Date getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
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
}