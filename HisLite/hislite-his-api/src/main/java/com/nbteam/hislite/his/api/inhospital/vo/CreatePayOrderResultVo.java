package com.nbteam.hislite.his.api.inhospital.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 支付中心下单
 *
 */
public class CreatePayOrderResultVo implements Serializable {
    private static final long serialVersionUID = 3669508933241995209L;

    /**
     * 支付订单号
     */
    private String payOrderId;
    /**
     * 收银台URL
     */
    private String cashierURI;
    /**
     * 二维码链接
     */
    private List<QrQueryResultVo> qrList;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getCashierURI() {
        return cashierURI;
    }

    public void setCashierURI(String cashierURI) {
        this.cashierURI = cashierURI;
    }

    public List<QrQueryResultVo> getQrList() {
        return qrList;
    }

    public void setQrList(List<QrQueryResultVo> qrList) {
        this.qrList = qrList;
    }
}
