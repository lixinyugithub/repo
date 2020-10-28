package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 医保订单查询接口<br/>
 *
 */
public class MedQueryOrderVo extends BaseResultVo {
    /** 
     */
    private static final long serialVersionUID = 3020250260457012699L;
    /** 订单状态 1-支付成功 2-支付失败 3-支付处理中 */
    private Integer ordertatus;
    /** 医保支付状态 1-支付成功 2-支付失败 3-支付处理中 */
    private Integer medStatus;
    /** 现金支付状态 1-支付成功 2-支付失败 3-支付处理中 */
    private Integer cashStatus;
    /** 现金支付总金额 */
    private Integer totalFee;
    /** 医保支付金额 */
    private Integer medPayFee;
    /** 自费部分支付金额 */
    private Integer selfPayFee;
    /** 订单支付时间 */
    private Date payedDate;
    /** 业务流水号 */
    private String serilNo;
    /** 医保订单号 */
    private String medTransactionId;
    /** 社保返回内容 */
    private String responseContent;

    /** {@linkplain #ordertatus} */
    public Integer getOrdertatus() {
        return ordertatus;
    }

    /** {@linkplain #ordertatus} */
    public void setOrdertatus(Integer ordertatus) {
        this.ordertatus = ordertatus;
    }

    /** {@linkplain #medStatus} */
    public Integer getMedStatus() {
        return medStatus;
    }

    /** {@linkplain #medStatus} */
    public void setMedStatus(Integer medStatus) {
        this.medStatus = medStatus;
    }

    /** {@linkplain #cashStatus} */
    public Integer getCashStatus() {
        return cashStatus;
    }

    /** {@linkplain #cashStatus} */
    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
    }

    /** {@linkplain #totalFee} */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** {@linkplain #totalFee} */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** {@linkplain #medPayFee} */
    public Integer getMedPayFee() {
        return medPayFee;
    }

    /** {@linkplain #medPayFee} */
    public void setMedPayFee(Integer medPayFee) {
        this.medPayFee = medPayFee;
    }

    /** {@linkplain #selfPayFee} */
    public Integer getSelfPayFee() {
        return selfPayFee;
    }

    /** {@linkplain #selfPayFee} */
    public void setSelfPayFee(Integer selfPayFee) {
        this.selfPayFee = selfPayFee;
    }

    /** {@linkplain #payedDate} */
    public Date getPayedDate() {
        return payedDate;
    }

    /** {@linkplain #payedDate} */
    public void setPayedDate(Date payedDate) {
        this.payedDate = payedDate;
    }

    /** {@linkplain #serilNo} */
    public String getSerilNo() {
        return serilNo;
    }

    /** {@linkplain #serilNo} */
    public void setSerilNo(String serilNo) {
        this.serilNo = serilNo;
    }

    /** {@linkplain #medTransactionId} */
    public String getMedTransactionId() {
        return medTransactionId;
    }

    /** {@linkplain #medTransactionId} */
    public void setMedTransactionId(String medTransactionId) {
        this.medTransactionId = medTransactionId;
    }

    /** {@linkplain #responseContent} */
    public String getResponseContent() {
        return responseContent;
    }

    /** {@linkplain #responseContent} */
    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

}
