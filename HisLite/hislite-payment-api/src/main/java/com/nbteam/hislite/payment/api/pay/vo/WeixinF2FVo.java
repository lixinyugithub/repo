package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信当面付返回数据转换<br/>
 *
 */
public class WeixinF2FVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = -598749718200353989L;
    /** 用户标识 */
    private String openid;
    /** 是否关注公众账号 */
    private String is_subscribe;
    /** 交易类型 */
    private String trade_type;
    /** 付款银行 */
    private String bank_type;
    /** 货币类型 */
    private String fee_type;
    /** 订单金额 */
    private Integer total_fee;
    /** 应结订单金额 */
    private Integer settlement_total_fee;
    /** 代金券金额 */
    private Integer coupon_fee;
    /** 现金支付货币类型 */
    private String cash_fee_type;
    /** 现金支付金额 */
    private Integer cash_fee;
    /** 微信支付订单号 */
    private String transaction_id;
    /** 商户订单号 */
    private String out_trade_no;
    /** 商家数据包 */
    private String attach;
    /** 支付完成时间 */
    private String time_end;
    /** 营销详情 */
    private String promotion_detail;

    /** {@linkplain #openid} */
    public String getOpenid() {
        return openid;
    }

    /** {@linkplain #openid} */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /** {@linkplain #is_subscribe} */
    public String getIs_subscribe() {
        return is_subscribe;
    }

    /** {@linkplain #is_subscribe} */
    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    /** {@linkplain #trade_type} */
    public String getTrade_type() {
        return trade_type;
    }

    /** {@linkplain #trade_type} */
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    /** {@linkplain #bank_type} */
    public String getBank_type() {
        return bank_type;
    }

    /** {@linkplain #bank_type} */
    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    /** {@linkplain #fee_type} */
    public String getFee_type() {
        return fee_type;
    }

    /** {@linkplain #fee_type} */
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
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

    /** {@linkplain #coupon_fee} */
    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    /** {@linkplain #coupon_fee} */
    public void setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    /** {@linkplain #cash_fee_type} */
    public String getCash_fee_type() {
        return cash_fee_type;
    }

    /** {@linkplain #cash_fee_type} */
    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    /** {@linkplain #cash_fee} */
    public Integer getCash_fee() {
        return cash_fee;
    }

    /** {@linkplain #cash_fee} */
    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

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

    /** {@linkplain #attach} */
    public String getAttach() {
        return attach;
    }

    /** {@linkplain #attach} */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /** {@linkplain #time_end} */
    public String getTime_end() {
        return time_end;
    }

    /** {@linkplain #time_end} */
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    /** {@linkplain #promotion_detail} */
    public String getPromotion_detail() {
        return promotion_detail;
    }

    /** {@linkplain #promotion_detail} */
    public void setPromotion_detail(String promotion_detail) {
        this.promotion_detail = promotion_detail;
    }

}
