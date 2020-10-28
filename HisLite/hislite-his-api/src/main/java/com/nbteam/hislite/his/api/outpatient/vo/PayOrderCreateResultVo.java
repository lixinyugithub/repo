package com.nbteam.hislite.his.api.outpatient.vo;


import java.io.Serializable;
import java.util.List;

/**
 * Description: 门诊中心支付下单返回参数<br/>
 *
 * @author liuqun
 * @version 1.0
 * @date: 2017/4/25 10:38
 * @since JDK 1.7
 */
public class PayOrderCreateResultVo implements Serializable {
    private static final long serialVersionUID = 3669508933241995209L;
    /**
     * 支付订单号
     */
    private Long payOrderId;
    /**
     * 收银台URL
     */
    private String cashierURI;
    /**
     * 交易订单号
     */
    private String tradeNo;
    /**
     * 二维码链接
     */
    private List<QrQueryResultVo> qrList;

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
