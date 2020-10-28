package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信退款返回对象<br/>
 *
 */
public class WeixinMedRefundQueryVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = -3831286684483660202L;
    /** 微信订单号 */
    private String med_trans_id;
    /** 商户订单号 */
    private String hosp_out_trade_no;
    /** 商户退款单号 */
    private Long hosp_out_refund_no;
    /** 微信退款单号 */
    private String med_refund_id;
    /** 申请退款金额 */
    private Integer cash_refund_fee;
    /** 医保退款金额 */
    private Integer insurance_refund_fee;
    /** 医保退款状态 */
    private String insurance_refund_status;
    /** 现金退款状态 */
    private String cash_refund_stauts;
    /** 退款单总状态 */
    private String med_refund_state;

    /** {@linkplain #med_trans_id} */
    public String getMed_trans_id() {
        return med_trans_id;
    }

    /** {@linkplain #med_trans_id} */
    public void setMed_trans_id(String med_trans_id) {
        this.med_trans_id = med_trans_id;
    }

    /** {@linkplain #hosp_out_trade_no} */
    public String getHosp_out_trade_no() {
        return hosp_out_trade_no;
    }

    /** {@linkplain #hosp_out_trade_no} */
    public void setHosp_out_trade_no(String hosp_out_trade_no) {
        this.hosp_out_trade_no = hosp_out_trade_no;
    }

    /** {@linkplain #hosp_out_refund_no} */
    public Long getHosp_out_refund_no() {
        return hosp_out_refund_no;
    }

    /** {@linkplain #hosp_out_refund_no} */
    public void setHosp_out_refund_no(Long hosp_out_refund_no) {
        this.hosp_out_refund_no = hosp_out_refund_no;
    }

    /** {@linkplain #med_refund_id} */
    public String getMed_refund_id() {
        return med_refund_id;
    }

    /** {@linkplain #med_refund_id} */
    public void setMed_refund_id(String med_refund_id) {
        this.med_refund_id = med_refund_id;
    }

    /** {@linkplain #cash_refund_fee} */
    public Integer getCash_refund_fee() {
        return cash_refund_fee;
    }

    /** {@linkplain #cash_refund_fee} */
    public void setCash_refund_fee(Integer cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
    }

    /** {@linkplain #insurance_refund_fee} */
    public Integer getInsurance_refund_fee() {
        return insurance_refund_fee;
    }

    /** {@linkplain #insurance_refund_fee} */
    public void setInsurance_refund_fee(Integer insurance_refund_fee) {
        this.insurance_refund_fee = insurance_refund_fee;
    }

    /** {@linkplain #insurance_refund_status} */
    public String getInsurance_refund_status() {
        return insurance_refund_status;
    }

    /** {@linkplain #insurance_refund_status} */
    public void setInsurance_refund_status(String insurance_refund_status) {
        this.insurance_refund_status = insurance_refund_status;
    }

    /** {@linkplain #cash_refund_stauts} */
    public String getCash_refund_stauts() {
        return cash_refund_stauts;
    }

    /** {@linkplain #cash_refund_stauts} */
    public void setCash_refund_stauts(String cash_refund_stauts) {
        this.cash_refund_stauts = cash_refund_stauts;
    }

    /** {@linkplain #med_refund_state} */
    public String getMed_refund_state() {
        return med_refund_state;
    }

    /** {@linkplain #med_refund_state} */
    public void setMed_refund_state(String med_refund_state) {
        this.med_refund_state = med_refund_state;
    }

}
