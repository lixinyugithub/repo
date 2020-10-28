package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 睿博统一下单支付返回数据<br/>
 *
 */
public class WitonUnifiedVo extends BaseResultVo {

    /** 
     */
    private static final long serialVersionUID = -8084841777671024015L;
    /** 医院ID */
    private String hospitalId;

    /** 订单号 */
    private String tradeMo;

    /** 支付URL */
    private String payUrl;

    /** 签名字段 */
    private String sign;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getTradeMo() {
        return tradeMo;
    }

    public void setTradeMo(String tradeMo) {
        this.tradeMo = tradeMo;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
