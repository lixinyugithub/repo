package com.nbteam.hislite.payment.api.pay.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * 登记支付单
 *
 */
public class UnifiedOrderParamVo extends BaseParamVo {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    /** 医院名称 */
    private String hisName;

    /** 业务平台来源 */
    @NotEmpty(message = "支付参数业务平台来源不能为空(支付宝、微信)")
    private String bizChannel;

    /** 业务类型 */
    @NotEmpty(message = "支付参数业务类型不能为空(住院、门诊)")
    private String bizType;

    /** 用户渠道标识（openId等） */
    @ApiModelProperty("用户姓名")
    private String channelUserId;

    /** 用户ID */
    @ApiModelProperty("用户卡号")
    private Long userId;

    /** 商品名称 */
    @NotEmpty(message = "支付参数商品名称不能为空")
    private String goodsName;

    /** 待金额 */
    @NotNull(message="支付金额不能为空")
    @Min(value=0,message="支付金额不合法")
    private Integer totalFee;

    /** 业务订单号 */
    @NotNull(message = "业务订单号不能为空")
    private Long bizOrderId;

    /** 支付渠道 */
    @NotEmpty(message = "支付参数支付渠道不能为空")
    private String payChannel;

    /** 支付方法 */
    @NotEmpty(message = "支付参数支付方法不能为空")
    private String payMethod;

    /** 第三方支付渠道支付订单号（无特殊情况为空，如医院需要医院的订单号对账，则此值不能为空） */
    private String merchantOrderId;

    /** 有效时长 */
    private Integer effectiveLength;

    /** ip地址 */
    private String ipAddress;

    /** 是否只支持医保支付 1-是 0-否 */
    private Integer isMedPay;

    /** 业务内容 */
    private String bizContent;

    /**************************************** 以下为医保参数信息 *************************************/

    /** 医保参数 */
    private MedUnifiedParamVo medUnifiedParamVo;
    

    /** 医院订单号 */
    private String hisOrderNo;


    /** 门诊批次号 */
    private String hisBillNo;

    
    public MedUnifiedParamVo getMedUnifiedParamVo() {
        return medUnifiedParamVo;
    }

    public void setMedUnifiedParamVo(MedUnifiedParamVo medUnifiedParamVo) {
        this.medUnifiedParamVo = medUnifiedParamVo;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
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

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Integer getEffectiveLength() {
        return effectiveLength;
    }

    public void setEffectiveLength(Integer effectiveLength) {
        this.effectiveLength = effectiveLength;
    }

	public String getHisOrderNo() {
		return hisOrderNo;
	}

	public void setHisOrderNo(String hisOrderNo) {
		this.hisOrderNo = hisOrderNo;
	}

	public String getHisBillNo() {
		return hisBillNo;
	}

	public void setHisBillNo(String hisBillNo) {
		this.hisBillNo = hisBillNo;
	}

}