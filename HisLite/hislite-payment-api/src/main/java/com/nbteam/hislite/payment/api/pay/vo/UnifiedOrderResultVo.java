package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.List;

/**
 * 
 * 统一下单返回(扫码付返回)
 *
 */
public class UnifiedOrderResultVo extends BaseResultVo {

    private static final long serialVersionUID = 1L;
    /** 支付订单号 */
    private Long payOrderId;
    /**
     * 交易订单号
     */
    private String tradeNo;
    /** 收银台URL */
    private String cashierURI;
    /** 二维码链接 */
    private List<QrResultVo> qrList;

    /** {@linkplain #payOrderId} */
    public Long getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    /** {@linkplain #cashierURI} */
    public String getCashierURI() {
        return cashierURI;
    }

    /** {@linkplain #cashierURI} */
    public void setCashierURI(String cashierURI) {
        this.cashierURI = cashierURI;
    }

    /** {@linkplain #qrList} */
    public List<QrResultVo> getQrList() {
        return qrList;
    }

    /** {@linkplain #qrList} */
    public void setQrList(List<QrResultVo> qrList) {
        this.qrList = qrList;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}