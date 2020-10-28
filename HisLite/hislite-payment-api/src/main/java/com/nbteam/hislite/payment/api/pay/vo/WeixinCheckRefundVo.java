package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信退款单查询结果<br/>
 *
 */
public class WeixinCheckRefundVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = 7348859820256093581L;
    /** 微信支付流水号 */
    private String transaction_id;
    /** 平台支付流水号 */
    private String out_trade_no;
    /** 支付金额 */
    private Integer total_fee;
    /** 退款次数 */
    private Integer refund_count;
    /** 平台退款orderId */
    private Long out_refund_no_0;
    /** 微信退款流水ID */
    private String refund_id_0;
    /** 申请退款金额 */
    private Integer refund_fee_0;
    /** 退款金额 */
    private Integer settlement_refund_fee_0;
    /** 退款状态 */
    private String refund_status_0;
    /** 退款成功时间 */
    private String refund_success_time_0;

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

    /** {@linkplain #total_fee} */
    public Integer getTotal_fee() {
        return total_fee;
    }

    /** {@linkplain #total_fee} */
    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    /** {@linkplain #refund_count} */
    public Integer getRefund_count() {
        return refund_count;
    }

    /** {@linkplain #refund_count} */
    public void setRefund_count(Integer refund_count) {
        this.refund_count = refund_count;
    }

    /** {@linkplain #out_refund_no_0} */
    public Long getOut_refund_no_0() {
        return out_refund_no_0;
    }

    /** {@linkplain #out_refund_no_0} */
    public void setOut_refund_no_0(Long out_refund_no_0) {
        this.out_refund_no_0 = out_refund_no_0;
    }

    /** {@linkplain #refund_id_0} */
    public String getRefund_id_0() {
        return refund_id_0;
    }

    /** {@linkplain #refund_id_0} */
    public void setRefund_id_0(String refund_id_0) {
        this.refund_id_0 = refund_id_0;
    }

    /** {@linkplain #refund_fee_0} */
    public Integer getRefund_fee_0() {
        return refund_fee_0;
    }

    /** {@linkplain #refund_fee_0} */
    public void setRefund_fee_0(Integer refund_fee_0) {
        this.refund_fee_0 = refund_fee_0;
    }

    /** {@linkplain #settlement_refund_fee_0} */
    public Integer getSettlement_refund_fee_0() {
        return settlement_refund_fee_0;
    }

    /** {@linkplain #settlement_refund_fee_0} */
    public void setSettlement_refund_fee_0(Integer settlement_refund_fee_0) {
        this.settlement_refund_fee_0 = settlement_refund_fee_0;
    }

    /** {@linkplain #refund_status_0} */
    public String getRefund_status_0() {
        return refund_status_0;
    }

    /** {@linkplain #refund_status_0} */
    public void setRefund_status_0(String refund_status_0) {
        this.refund_status_0 = refund_status_0;
    }

    /** {@linkplain #refund_success_time_0} */
    public String getRefund_success_time_0() {
        return refund_success_time_0;
    }

    /** {@linkplain #refund_success_time_0} */
    public void setRefund_success_time_0(String refund_success_time_0) {
        this.refund_success_time_0 = refund_success_time_0;
    }

}
