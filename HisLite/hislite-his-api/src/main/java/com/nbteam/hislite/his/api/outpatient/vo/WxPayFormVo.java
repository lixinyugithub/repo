package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;

/**
 * 
 * Description: 微信支付表单vo<br/>
 *
 * @author liujingcheng
 * @date: 2016年10月25日 下午8:18:59
 * @version 1.0
 * @since JDK 1.7
 */
public class WxPayFormVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = 2305928034353699216L;

    /**
     * 医院id 必填
     */
    private Long hisId;

    /**
     * 业务类型 包含register inpatient_pay outpatient_pay 必填
     */
    private String bizType;

    /**
     * 微信公众账号id 必填
     */
    private String appId;

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB" 网页支付或者公众号支付可为空
     */
    private String deviceInfo;
    /**
     * 商品描述
     */
    private String body;

    /**
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 选填
     */
    private String attach;
    /**
     * 业务订单号 必填
     */
    private Long bizOrderId;
    /**
     * 医院订单号 必填
     */
    private String hisOrderNo;
    /**
     * 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY 选填
     */
    private String feeType;
    /**
     * 订单总金额，只能为整数，单位是分 必填
     */
    private Integer totalFee;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010 选填
     */
    private String timeStart;
    /**
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010 选填
     */
    private String timeExpire;
    /**
     * 商品标记，代金券或立减优惠功能的参数 选填
     */
    private String goodsTag;
    /**
     * 商品id trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    private String productId;
    /**
     * 指定支付方式 no_credit--指定不能使用信用卡支付 选填
     */
    private String limitPay;
    /**
     * 详情
     */
    private DetailVo detail = new DetailVo();

    /** 返回 医院id 必填 */
    public Long getHisId() {
        return hisId;
    }

    /** 设置 医院id 必填 */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** 返回 业务类型 包含register inpatient_pay outpatient_pay 必填 */
    public String getBizType() {
        return bizType;
    }

    /** 设置 业务类型 包含register inpatient_pay outpatient_pay 必填 */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /** 返回 微信公众账号id 必填 */
    public String getAppId() {
        return appId;
    }

    /** 设置 微信公众账号id 必填 */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /** 返回 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB" 网页支付或者公众号支付可为空 */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /** 设置 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB" 网页支付或者公众号支付可为空 */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * 返回 商品描述
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置 商品描述
     */
    public void setBody(String body) {
        this.body = body;
    }

    /** 返回 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 选填 */
    public String getAttach() {
        return attach;
    }

    /** 设置 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 选填 */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /** 返回 业务订单号 必填 */
    public Long getBizOrderId() {
        return bizOrderId;
    }

    /** 设置 业务订单号 必填 */
    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    /** 返回 医院订单号 必填 */
    public String getHisOrderNo() {
        return hisOrderNo;
    }

    /** 设置 医院订单号 必填 */
    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    /** 返回 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY 选填 */
    public String getFeeType() {
        return feeType;
    }

    /** 设置 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY 选填 */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /** 返回 订单总金额，只能为整数，单位是分 必填 */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** 设置 订单总金额，只能为整数，单位是分 必填 */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** 返回 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010 选填 */
    public String getTimeStart() {
        return timeStart;
    }

    /** 设置 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010 选填 */
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    /** 返回 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010 选填 */
    public String getTimeExpire() {
        return timeExpire;
    }

    /** 设置 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010 选填 */
    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    /** 返回 商品标记，代金券或立减优惠功能的参数 选填 */
    public String getGoodsTag() {
        return goodsTag;
    }

    /** 设置 商品标记，代金券或立减优惠功能的参数 选填 */
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    /** 返回 商品id trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。 */
    public String getProductId() {
        return productId;
    }

    /** 设置 商品id trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。 */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** 返回 指定支付方式 no_credit--指定不能使用信用卡支付 选填 */
    public String getLimitPay() {
        return limitPay;
    }

    /** 设置 指定支付方式 no_credit--指定不能使用信用卡支付 选填 */
    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    /** 返回 详情 */
    public DetailVo getDetail() {
        return detail;
    }

    /** 设置 详情 */
    public void setDetail(DetailVo detail) {
        this.detail = detail;
    }

}
