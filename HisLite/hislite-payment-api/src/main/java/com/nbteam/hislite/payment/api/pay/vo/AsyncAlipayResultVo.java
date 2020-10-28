package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;

/**
 * 
 * 支付宝回传
 *
 */
public class AsyncAlipayResultVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //交易订单号(海鹚)
    private String outTradeNo;
    //交易流水号(支付宝)
    private String tradeNo;
    //交易金额
    private Integer totalFee;
    //卖家id
    private String sellerId;
    //买家支付宝id
    private String buyerLogonIid;
    //付款时间
    private String gmtPayment;
    //通知时间
    private String notify_time;
    
    private String notify_type;
    
    private String notify_id;
    
    private String app_id;
    //字符集
    private String charset;
    //版本
    private String version;
    //加密类型
    private String sign_type;
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public Integer getTotalFee() {
        return totalFee;
    }
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    public String getBuyerLogonIid() {
        return buyerLogonIid;
    }
    public void setBuyerLogonIid(String buyerLogonIid) {
        this.buyerLogonIid = buyerLogonIid;
    }
    public String getGmtPayment() {
        return gmtPayment;
    }
    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }
    public String getNotify_time() {
        return notify_time;
    }
    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }
    public String getNotify_type() {
        return notify_type;
    }
    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }
    public String getNotify_id() {
        return notify_id;
    }
    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }
    public String getApp_id() {
        return app_id;
    }
    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
    public String getCharset() {
        return charset;
    }
    public void setCharset(String charset) {
        this.charset = charset;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getSign_type() {
        return sign_type;
    }
    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    //加密
    private String sign;


}
