package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 统一下单支付返回数据<br/>
 *
 */
public class UnifiedOrderVo extends BaseResultVo {

    /** 
     */
    private static final long serialVersionUID = -8084841777671024015L;
    /** appId */
    private String appId;
    /** 商户号 */
    private String merchantId;
    /** 预支付Id */
    private String prePayId;
    /** 交易类型 */
    private String tradeType;
    /** 二维码code */
    private String codeUrl;
    /** 商户秘钥 */
    private String merchantKey;
    /** 支付宝下单统一返回form */
    private String cashierURI;
    /** 诊疗单ID */
    private String medTransactionId;
    /** 医保支付URL */
    private String payUrl;

    /** {@linkplain #medTransactionId} */
    public String getMedTransactionId() {
        return medTransactionId;
    }

    /** {@linkplain #medTransactionId} */
    public void setMedTransactionId(String medTransactionId) {
        this.medTransactionId = medTransactionId;
    }

    /** {@linkplain #payUrl} */
    public String getPayUrl() {
        return payUrl;
    }

    /** {@linkplain #payUrl} */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    /** {@linkplain #cashierURI} */
    public String getCashierURI() {
        return cashierURI;
    }

    /** {@linkplain #cashierURI} */
    public void setCashierURI(String cashierURI) {
        this.cashierURI = cashierURI;
    }

    /** {@linkplain #merchantKey} */
    public String getMerchantKey() {
        return merchantKey;
    }

    /** {@linkplain #merchantKey} */
    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    /** {@linkplain #appId} */
    public String getAppId() {
        return appId;
    }

    /** {@linkplain #appId} */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /** {@linkplain #merchantId} */
    public String getMerchantId() {
        return merchantId;
    }

    /** {@linkplain #merchantId} */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /** {@linkplain #prePayId} */
    public String getPrePayId() {
        return prePayId;
    }

    /** {@linkplain #prePayId} */
    public void setPrePayId(String prePayId) {
        this.prePayId = prePayId;
    }

    /** {@linkplain #tradeType} */
    public String getTradeType() {
        return tradeType;
    }

    /** {@linkplain #tradeType} */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    /** {@linkplain #codeUrl} */
    public String getCodeUrl() {
        return codeUrl;
    }

    /** {@linkplain #codeUrl} */
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

}
