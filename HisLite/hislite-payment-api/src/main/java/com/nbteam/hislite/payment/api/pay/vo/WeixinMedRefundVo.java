package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 医保退款返回数据<br/>
 *
 */
public class WeixinMedRefundVo extends WeixinBaseVo {
    /** 
     */
    private static final long serialVersionUID = -5792838739433480457L;
    /** 订单总金额 */
    private Integer total_fee;
    /** 现金退款金额 */
    private Integer cash_refund_fee;
    /** 医保退款金额（目前只能全额退） */
    private Integer insurance_refund_fee;
    /** 微信生成的退款医疗订单号 */
    private String med_refund_id;

    /** {@linkplain #total_fee} */
    public Integer getTotal_fee() {
        return total_fee;
    }

    /** {@linkplain #total_fee} */
    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
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

    /** {@linkplain #med_refund_id} */
    public String getMed_refund_id() {
        return med_refund_id;
    }

    /** {@linkplain #med_refund_id} */
    public void setMed_refund_id(String med_refund_id) {
        this.med_refund_id = med_refund_id;
    }

}
