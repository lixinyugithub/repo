package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 综合下单vo
 *
 */
public class PaySerialVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 支付流水号 */
    private Long paySerialId;

    /** 支付订单号 */
    private Long payOrderId;

    /** 支付方式 */
    private String payMode;

    /** 支付渠道 */
    private String payChannel;

    /** 支付方法 */
    private String payMethod;

    /** 总金额 */
    private Integer totalFee;

    /** 医保部分金额 */
    private Integer medicareFee;

    /** 支付扣减金额 */
    private Integer discountFee;

    /** 自费部分金额 */
    private Integer fee;

    /** 状态（U-预登记 S-成功 I-未知 F-失败 O-已撤销 C-超时关闭 R-退款） */
    private String status;

    /** 支付超时时间 */
    private Date overTime;

    /** 内部商户Id */
    private Long insideMerchantId;

    /** 商户号 */
    private String merchantId;

    /** 商户订单Id */
    private String merchantOrderId;

    /** 预支付Id */
    private String prePayNo;

    /** 支付时间 */
    private Date payedTime;

    /** 支付渠道流水 */
    private String acquireSerialNo;

    /** 支付银行 */
    private String bank;

    /** 银行流水 */
    private String bankSerialNo;

    /** 支付渠道用户ID */
    private String channelUserId;
    
    /** 医院订单号 */
    private String hisOrderNo;
    
    /**  门诊批次号 */
    private String hisBillNO;

    /** 扩展字段 */
    private String extFields;

    /************************ 需要扩展的字段 *****************************/
    /** 商品信息 */
    private String body;

    /** ip地址 */
    private String spbillCreateIp;

    /** 客户条码code */
    private String authCode;

    /** JSAPI，NATIVE，APP */
    private String tradeType;

    /** 设备信息 */
    private String deviceInfo;
    /** 附加数据 */
    private String attach;
    /** 商户的操作员编号 */
    private String operatorId;

    private String storeId;

    /**
     * 支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code 默认：bar_code
     */
    private String scene = "bar_code";
    /** appId */
    private String appId;
    /** 平台ID */
    private Long platformId;
    /** 业务类型 */
    private String bizType;
    /** 医院名称 */
    private String hisName;
    /** 医院ID */
    private Long hisId;
    /** 支付回调URL */
    private String returnUrl;

    /************************ 睿博支付需要扩展的字段 *****************************/
    /** 支付方式 wechat-微信 alipay-支付宝 */
    private String bizContent;
    /** 卡号 */
    private String patCardNo;
    /** 姓名 */
    private String patientName;

    /** {@linkplain #returnUrl} */
    public String getReturnUrl() {
        return returnUrl;
    }

    /** {@linkplain #returnUrl} */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    /** {@linkplain #hisId} */
    public Long getHisId() {
        return hisId;
    }

    /** {@linkplain #hisId} */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** {@linkplain #hisName} */
    public String getHisName() {
        return hisName;
    }

    /** {@linkplain #hisName} */
    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    /** {@linkplain #bizType} */
    public String getBizType() {
        return bizType;
    }

    /** {@linkplain #bizType} */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /** {@linkplain #platformId} */
    public Long getPlatformId() {
        return platformId;
    }

    /** {@linkplain #platformId} */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /** {@linkplain #appId} */
    public String getAppId() {
        return appId;
    }

    /** {@linkplain #appId} */
    public void setAppId(String appId) {
        this.appId = appId;
    }

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

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

	public String getHisOrderNo() {
		return hisOrderNo;
	}

	public void setHisOrderNo(String hisOrderNo) {
		this.hisOrderNo = hisOrderNo;
	}

	public String getHisBillNO() {
		return hisBillNO;
	}

	public void setHisBillNO(String hisBillNO) {
		this.hisBillNO = hisBillNO;
	}

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}