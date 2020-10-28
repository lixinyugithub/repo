package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 统一下单返回(扫码付返回)
 *
 */
public class ScanPayResultVo extends BaseResultVo {
    /** 
     */
    private static final long serialVersionUID = -3223649421654294030L;

    /**
     * 网页支付时返回
     */
    private String prepayId;
    /**
     * 扫码付时返回
     */
    private String codeUrl;

    /**
     * 网页支付页面
     */
    private String form;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

}