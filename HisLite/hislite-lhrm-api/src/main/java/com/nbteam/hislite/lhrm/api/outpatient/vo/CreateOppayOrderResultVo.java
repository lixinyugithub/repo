package com.nbteam.hislite.lhrm.api.outpatient.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Map;

public class CreateOppayOrderResultVo extends BaseResultVo {
    private static final long serialVersionUID = 1L;

    /**
     * 医院ID
     */
    private String hospitalId;

    /**
     * 订单号
     */
    private String tradeNo;
    /**
     * 支付URL
     */
    private String payUrl;

    /** 签名字段 */
    private String sign;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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