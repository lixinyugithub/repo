package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 微信统一下单返回对象的内容
 *
 */
public class WeixinUnifiedVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = 4808423735163729731L;
    private String trade_type;
    private String prepay_id;
    private String code_url;

    /** {@linkplain #trade_type} */
    public String getTrade_type() {
        return trade_type;
    }

    /** {@linkplain #trade_type} */
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    /** {@linkplain #prepay_id} */
    public String getPrepay_id() {
        return prepay_id;
    }

    /** {@linkplain #prepay_id} */
    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    /** {@linkplain #code_url} */
    public String getCode_url() {
        return code_url;
    }

    /** {@linkplain #code_url} */
    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

}
