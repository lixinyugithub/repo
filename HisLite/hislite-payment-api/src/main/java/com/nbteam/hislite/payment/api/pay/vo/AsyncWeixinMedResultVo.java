package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信医保支付回传对象<br/>
 *
 */
public class AsyncWeixinMedResultVo extends WeixinBaseVo {
    /** 
     */  
    private static final long serialVersionUID = -800818595168464342L;
    /** 用户标识 */
    private String openid;
    /** 用户子标识 */
    private String sub_openid;
    /** 微信支付生成的医疗订单号 */
    private String med_trans_id;
    /** 医院订单号 */
    private String hosp_out_trade_no;
    /** 订单支付时间 */
    private String time_end;
    /** 支付类型 2:医保 3:现金+医保 */
    private Integer pay_type;
    /** 总共需要支付的现金金额 */
    private Integer total_fee;
    /** 现金支付金额 */
    private Integer cash_fee;
    /** 医保支付金额 */
    private Integer insurance_fee;
    /** 诊疗证编号 */
    private String medical_card_id;
    /** 社保支付成功后返回内容 */
    private String response_content;
    /** 签名 */
    private String sign;

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

    /** {@linkplain #time_end} */
    public String getTime_end() {
        return time_end;
    }

    /** {@linkplain #time_end} */
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    /** {@linkplain #pay_type} */
    public Integer getPay_type() {
        return pay_type;
    }

    /** {@linkplain #pay_type} */
    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
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

    /** {@linkplain #insurance_fee} */
    public Integer getInsurance_fee() {
        return insurance_fee;
    }

    /** {@linkplain #insurance_fee} */
    public void setInsurance_fee(Integer insurance_fee) {
        this.insurance_fee = insurance_fee;
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

    /** {@linkplain #sign} */
    public String getSign() {
        return sign;
    }

    /** {@linkplain #sign} */
    public void setSign(String sign) {
        this.sign = sign;
    }

}
