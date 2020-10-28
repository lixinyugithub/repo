package com.nbteam.hislite.payment.api.pay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class PaymentMerchant implements Serializable {
    @ApiModelProperty("内部商户ID")
    private Long insideMerchantId;

    @ApiModelProperty("内部商户名")
    private String insideMerchantName;

    @ApiModelProperty("使用状态（1-正常使用 2-暂停使用）")
    private Integer status;

    @ApiModelProperty("支付渠道")
    private String payChannel;

    @ApiModelProperty("商户id")
    private String merchantId;

    @ApiModelProperty("服务商id")
    private String serviceMerchantId;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("商户appId")
    private String appId;

    @ApiModelProperty("服务商appId")
    private String serviceAppId;

    @ApiModelProperty("商户账号（wap版本有用）")
    private String merchantAccount;

    @ApiModelProperty("支付key")
    private String paymentKey;

    @ApiModelProperty("医保支付秘钥")
    private String medPaymentKey;

    @ApiModelProperty("公众号appSecret")
    private String appSecret;

    @ApiModelProperty("生活号公钥")
    private String publicKey;

    @ApiModelProperty("私钥")
    private String privateKey;

    @ApiModelProperty("医院的医疗机构编码")
    private String medOrgNo;

    @ApiModelProperty("商户版本号")
    private String merchantVersion;

    @ApiModelProperty("业务规则开关（第一位，是否限制使用信用卡：0-限制、1-不限制）")
    private String switchs;

    @ApiModelProperty("第三方开发者appid")
    private String componentAppid;

    @ApiModelProperty("授权Token")
    private String authorizerAccessToken;

    @ApiModelProperty("业务商编号")
    private String providerId;

    @ApiModelProperty("扩展字段")
    private String extFields;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getInsideMerchantId() {
        return insideMerchantId;
    }

    public void setInsideMerchantId(Long insideMerchantId) {
        this.insideMerchantId = insideMerchantId;
    }

    public String getInsideMerchantName() {
        return insideMerchantName;
    }

    public void setInsideMerchantName(String insideMerchantName) {
        this.insideMerchantName = insideMerchantName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getServiceMerchantId() {
        return serviceMerchantId;
    }

    public void setServiceMerchantId(String serviceMerchantId) {
        this.serviceMerchantId = serviceMerchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getServiceAppId() {
        return serviceAppId;
    }

    public void setServiceAppId(String serviceAppId) {
        this.serviceAppId = serviceAppId;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getMedPaymentKey() {
        return medPaymentKey;
    }

    public void setMedPaymentKey(String medPaymentKey) {
        this.medPaymentKey = medPaymentKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getMedOrgNo() {
        return medOrgNo;
    }

    public void setMedOrgNo(String medOrgNo) {
        this.medOrgNo = medOrgNo;
    }

    public String getMerchantVersion() {
        return merchantVersion;
    }

    public void setMerchantVersion(String merchantVersion) {
        this.merchantVersion = merchantVersion;
    }

    public String getSwitchs() {
        return switchs;
    }

    public void setSwitchs(String switchs) {
        this.switchs = switchs;
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
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