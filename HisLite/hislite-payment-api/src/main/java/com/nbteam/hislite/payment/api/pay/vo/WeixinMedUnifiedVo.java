package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信医保统一下单返回结果参数<br/>
 *
 */
public class WeixinMedUnifiedVo extends WeixinBaseVo {

    /** 
     */
    private static final long serialVersionUID = -177696235849491874L;

    private String med_trans_id;

    private String pay_url;

    /** {@linkplain #med_trans_id} */
    public String getMed_trans_id() {
        return med_trans_id;
    }

    /** {@linkplain #med_trans_id} */
    public void setMed_trans_id(String med_trans_id) {
        this.med_trans_id = med_trans_id;
    }

    /** {@linkplain #pay_url} */
    public String getPay_url() {
        return pay_url;
    }

    /** {@linkplain #pay_url} */
    public void setPay_url(String pay_url) {
        this.pay_url = pay_url;
    }

}
