package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信退款返回对象<br/>
 *
 */
public class WeixinRefundVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = -3831286684483660202L;
    /** 微信订单号 */
    private String transaction_id;
    /** 商户订单号 */
    private String out_trade_no;
    /** 商户退款单号 */
    private Long out_refund_no;
    /** 微信退款单号 */
    private String refund_id;
    /** 申请退款金额 */
    private Integer refund_fee;
    /** 退款金额 */
    private Integer settlement_refund_fee;
    /** 订单金额 */
    private Integer total_fee;
    /** 应结订单金额 */
    private Integer settlement_total_fee;
    /** 货币种类 */
    private String fee_type;
    /** 现金支付金额 */
    private Integer cash_fee;
    /** 现金退款金额 */
    private Integer cash_refund_fee;

    /** {@linkplain #transaction_id} */
    public String getTransaction_id() {
        return transaction_id;
    }

    /** {@linkplain #transaction_id} */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    /** {@linkplain #out_trade_no} */
    public String getOut_trade_no() {
        return out_trade_no;
    }

    /** {@linkplain #out_trade_no} */
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    /** {@linkplain #out_refund_no} */
    public Long getOut_refund_no() {
        return out_refund_no;
    }

    /** {@linkplain #out_refund_no} */
    public void setOut_refund_no(Long out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    /** {@linkplain #refund_id} */
    public String getRefund_id() {
        return refund_id;
    }

    /** {@linkplain #refund_id} */
    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    /** {@linkplain #refund_fee} */
    public Integer getRefund_fee() {
        return refund_fee;
    }

    /** {@linkplain #refund_fee} */
    public void setRefund_fee(Integer refund_fee) {
        this.refund_fee = refund_fee;
    }

    /** {@linkplain #settlement_refund_fee} */
    public Integer getSettlement_refund_fee() {
        return settlement_refund_fee;
    }

    /** {@linkplain #settlement_refund_fee} */
    public void setSettlement_refund_fee(Integer settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
    }

    /** {@linkplain #total_fee} */
    public Integer getTotal_fee() {
        return total_fee;
    }

    /** {@linkplain #total_fee} */
    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    /** {@linkplain #settlement_total_fee} */
    public Integer getSettlement_total_fee() {
        return settlement_total_fee;
    }

    /** {@linkplain #settlement_total_fee} */
    public void setSettlement_total_fee(Integer settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    /** {@linkplain #fee_type} */
    public String getFee_type() {
        return fee_type;
    }

    /** {@linkplain #fee_type} */
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    /** {@linkplain #cash_fee} */
    public Integer getCash_fee() {
        return cash_fee;
    }

    /** {@linkplain #cash_fee} */
    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

    /** {@linkplain #cash_refund_fee} */
    public Integer getCash_refund_fee() {
        return cash_refund_fee;
    }

    /** {@linkplain #cash_refund_fee} */
    public void setCash_refund_fee(Integer cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
    }

}
