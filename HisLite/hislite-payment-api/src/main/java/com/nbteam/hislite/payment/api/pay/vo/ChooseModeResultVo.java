package com.nbteam.hislite.payment.api.pay.vo;

import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 选择支付方式返回结果<br/>
 *
 */
public class ChooseModeResultVo extends BaseResultVo {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -1787043633939002172L;
    /** 支付方式 */
    private String payMode;
    /** 支付参数 */
    private JSONObject payParameter;
    /** 支付ID */
    private Long payOrderId;
    /** 二维码链接 */
    private QrResultVo qr;
    /** 医保支付URL */
    private String payUrl;

    /** {@linkplain #payUrl} */
    public String getPayUrl() {
        return payUrl;
    }

    /** {@linkplain #payUrl} */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    /** {@linkplain #qr} */
    public QrResultVo getQr() {
        return qr;
    }

    /** {@linkplain #qr} */
    public void setQr(QrResultVo qr) {
        this.qr = qr;
    }

    /** {@linkplain #payMode} */
    public String getPayMode() {
        return payMode;
    }

    /** {@linkplain #payMode} */
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    /** {@linkplain #payParameter} */
    public JSONObject getPayParameter() {
        return payParameter;
    }

    /** {@linkplain #payParameter} */
    public void setPayParameter(JSONObject payParameter) {
        this.payParameter = payParameter;
    }

    /** {@linkplain #payOrderId} */
    public Long getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

}
