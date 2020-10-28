package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信医保订单查询结果<br/>
 *
 */
public class WeixinMedOrderQueryVo extends WeixinBaseVo {
    /** 
     */  
    private static final long serialVersionUID = 8710446806395422877L;
    /**
     * 交易状态 SUCCESS—支付成功 REFUND—转入退款 SYS_REFUNDED-系统退款 SYS_REFUNDING-系统退款中
     * NOTPAY—未支付 CLOSED —已关闭 PAYERROR —支付失败
     */
    private String med_trade_state;
    /**
     * 现金支付状态 SUCCESS—支付成功 REFUND—转入退款 NOTPAY—未支付 CLOSED—已关闭 USERPAYING--用户支付中
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    private String cash_trade_status;
    /**
     * 医保支付状态 PAYED—已支付 REFUND—转入退款 NOTPAY—未支付 CLOSED —已关闭
     */
    private String insurance_trade_status;
    /** 对当前查询订单状态的描述和下一步操作的指引 */
    private String trade_status_desc;
    /** 订单支付时间，格式为yyyyMMddHHmmss */
    private String time_end;
    /** 订单类型 RegPay=挂号支付 DiagPay=诊间支付 */
    private String order_type;
    /** 支付类型 2:医保 3:现金+医保 */
    private Integer pay_type;
    /** 用户标识 */
    private String openid;
    /** 用户子标识 */
    private String sub_openid;
    /** 总共需要支付金额 */
    private Integer total_fee;
    /** 现金需要支付的金额 */
    private Integer cash_fee;
    /** 是否允许预结算费用发生变化 */
    private Integer allow_fee_change;
    /** 用户端ip */
    private String spbill_create_ip;
    /** 医保支付金额 */
    private Integer insurance_fee;
    /** 业务流水号 */
    private String serial_no;
    /** 医疗机构编码 */
    private String org_no;
    /** 诊疗证编号 */
    private String medical_card_id;
    /** 支付完成后社保返回内容串 */
    private String response_content;
    /** 微信生成的医疗订单号 */
    private String med_trans_id;

    /** {@linkplain #med_trade_state} */
    public String getMed_trade_state() {
        return med_trade_state;
    }

    /** {@linkplain #med_trade_state} */
    public void setMed_trade_state(String med_trade_state) {
        this.med_trade_state = med_trade_state;
    }

    /** {@linkplain #cash_trade_status} */
    public String getCash_trade_status() {
        return cash_trade_status;
    }

    /** {@linkplain #cash_trade_status} */
    public void setCash_trade_status(String cash_trade_status) {
        this.cash_trade_status = cash_trade_status;
    }

    /** {@linkplain #insurance_trade_status} */
    public String getInsurance_trade_status() {
        return insurance_trade_status;
    }

    /** {@linkplain #insurance_trade_status} */
    public void setInsurance_trade_status(String insurance_trade_status) {
        this.insurance_trade_status = insurance_trade_status;
    }

    /** {@linkplain #trade_status_desc} */
    public String getTrade_status_desc() {
        return trade_status_desc;
    }

    /** {@linkplain #trade_status_desc} */
    public void setTrade_status_desc(String trade_status_desc) {
        this.trade_status_desc = trade_status_desc;
    }

    /** {@linkplain #time_end} */
    public String getTime_end() {
        return time_end;
    }

    /** {@linkplain #time_end} */
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    /** {@linkplain #order_type} */
    public String getOrder_type() {
        return order_type;
    }

    /** {@linkplain #order_type} */
    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    /** {@linkplain #pay_type} */
    public Integer getPay_type() {
        return pay_type;
    }

    /** {@linkplain #pay_type} */
    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    /** {@linkplain #openid} */
    public String getOpenid() {
        return openid;
    }

    /** {@linkplain #openid} */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /** {@linkplain #sub_openid} */
    public String getSub_openid() {
        return sub_openid;
    }

    /** {@linkplain #sub_openid} */
    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    /** {@linkplain #total_fee} */
    public Integer getTotal_fee() {
        return total_fee;
    }

    /** {@linkplain #total_fee} */
    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    /** {@linkplain #cash_fee} */
    public Integer getCash_fee() {
        return cash_fee;
    }

    /** {@linkplain #cash_fee} */
    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

    /** {@linkplain #allow_fee_change} */
    public Integer getAllow_fee_change() {
        return allow_fee_change;
    }

    /** {@linkplain #allow_fee_change} */
    public void setAllow_fee_change(Integer allow_fee_change) {
        this.allow_fee_change = allow_fee_change;
    }

    /** {@linkplain #spbill_create_ip} */
    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    /** {@linkplain #spbill_create_ip} */
    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    /** {@linkplain #insurance_fee} */
    public Integer getInsurance_fee() {
        return insurance_fee;
    }

    /** {@linkplain #insurance_fee} */
    public void setInsurance_fee(Integer insurance_fee) {
        this.insurance_fee = insurance_fee;
    }

    /** {@linkplain #serial_no} */
    public String getSerial_no() {
        return serial_no;
    }

    /** {@linkplain #serial_no} */
    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    /** {@linkplain #org_no} */
    public String getOrg_no() {
        return org_no;
    }

    /** {@linkplain #org_no} */
    public void setOrg_no(String org_no) {
        this.org_no = org_no;
    }

    /** {@linkplain #medical_card_id} */
    public String getMedical_card_id() {
        return medical_card_id;
    }

    /** {@linkplain #medical_card_id} */
    public void setMedical_card_id(String medical_card_id) {
        this.medical_card_id = medical_card_id;
    }

    /** {@linkplain #response_content} */
    public String getResponse_content() {
        return response_content;
    }

    /** {@linkplain #response_content} */
    public void setResponse_content(String response_content) {
        this.response_content = response_content;
    }

    /** {@linkplain #med_trans_id} */
    public String getMed_trans_id() {
        return med_trans_id;
    }

    /** {@linkplain #med_trans_id} */
    public void setMed_trans_id(String med_trans_id) {
        this.med_trans_id = med_trans_id;
    }

}
