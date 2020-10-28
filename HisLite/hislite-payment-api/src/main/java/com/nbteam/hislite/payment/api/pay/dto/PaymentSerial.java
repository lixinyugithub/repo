package com.nbteam.hislite.payment.api.pay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class PaymentSerial implements Serializable {
    @ApiModelProperty("支付流水号")
    private Long paySerialId;

    @ApiModelProperty("支付订单号")
    private Long payOrderId;

    @ApiModelProperty("支付方式")
    private String payMode;

    @ApiModelProperty("支付渠道")
    private String payChannel;

    @ApiModelProperty("支付方法")
    private String payMethod;

    @ApiModelProperty("总金额")
    private Integer totalFee;

    @ApiModelProperty("医保部分金额")
    private Integer medicareFee;

    @ApiModelProperty("支付扣减金额")
    private Integer discountFee;

    @ApiModelProperty("自费部分金额")
    private Integer fee;

    @ApiModelProperty("状态（U-预登记 S-成功 I-未知 F-失败 O-已撤销 C-超时关闭 R-退款）")
    private String status;

    @ApiModelProperty("支付超时时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date overTime;

    @ApiModelProperty("内部商户Id")
    private Long insideMerchantId;

    @ApiModelProperty("商户号")
    private String merchantId;

    @ApiModelProperty("商户订单Id")
    private String merchantOrderId;

    @ApiModelProperty("预支付Id")
    private String prePayNo;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    @ApiModelProperty("支付渠道流水")
    private String acquireSerialNo;

    @ApiModelProperty("支付银行")
    private String bank;

    @ApiModelProperty("银行流水")
    private String bankSerialNo;

    @ApiModelProperty("支付渠道用户ID")
    private String channelUserId;

    @ApiModelProperty("诊疗证编号")
    private String medicalCardId;

    @ApiModelProperty("医保支付返回内容")
    private String medResponseContent;

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

    public Long getPaySerialId() {
        return paySerialId;
    }

    public void setPaySerialId(Long paySerialId) {
        this.paySerialId = paySerialId;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
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

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
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

    public String getAcquireSerialNo() {
        return acquireSerialNo;
    }

    public void setAcquireSerialNo(String acquireSerialNo) {
        this.acquireSerialNo = acquireSerialNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankSerialNo() {
        return bankSerialNo;
    }

    public void setBankSerialNo(String bankSerialNo) {
        this.bankSerialNo = bankSerialNo;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    public String getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(String medicalCardId) {
        this.medicalCardId = medicalCardId;
    }

    public String getMedResponseContent() {
        return medResponseContent;
    }

    public void setMedResponseContent(String medResponseContent) {
        this.medResponseContent = medResponseContent;
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