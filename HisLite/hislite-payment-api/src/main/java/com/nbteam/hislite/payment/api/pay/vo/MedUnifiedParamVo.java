package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 医保支付参数Vo<br/>
 *
 */
public class MedUnifiedParamVo implements Serializable {
    /** 
     */
    private static final long serialVersionUID = -6333694770254212487L;
    /** 医保参数 */
    private String medicareParam;
    /** 证件类型 */
    private Integer cardType;
    /** 证件号 */
    private String cardNo;
    /** 就诊人真实姓名 */
    private String patientName;
    /** 医院下单时间 */
    private Date hisOrderTime;
    /** 医院的订单单据号，诊间支付时必传 */
    private String billNo;
    /** 医院订单流水号 */
    private String hisSerilno;
    /** 平台Id */
    private Long platformId;

    /** {@linkplain #platformId} */
    public Long getPlatformId() {
        return platformId;
    }

    /** {@linkplain #platformId} */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /** {@linkplain #medicareParam} */
    public String getMedicareParam() {
        return medicareParam;
    }

    /** {@linkplain #medicareParam} */
    public void setMedicareParam(String medicareParam) {
        this.medicareParam = medicareParam;
    }

    /** {@linkplain #cardType} */
    public Integer getCardType() {
        return cardType;
    }

    /** {@linkplain #cardType} */
    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    /** {@linkplain #cardNo} */
    public String getCardNo() {
        return cardNo;
    }

    /** {@linkplain #cardNo} */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /** {@linkplain #patientName} */
    public String getPatientName() {
        return patientName;
    }

    /** {@linkplain #patientName} */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /** {@linkplain #hisOrderTime} */
    public Date getHisOrderTime() {
        return hisOrderTime;
    }

    /** {@linkplain #hisOrderTime} */
    public void setHisOrderTime(Date hisOrderTime) {
        this.hisOrderTime = hisOrderTime;
    }

    /** {@linkplain #billNo} */
    public String getBillNo() {
        return billNo;
    }

    /** {@linkplain #billNo} */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /** {@linkplain #hisSerilno} */
    public String getHisSerilno() {
        return hisSerilno;
    }

    /** {@linkplain #hisSerilno} */
    public void setHisSerilno(String hisSerilno) {
        this.hisSerilno = hisSerilno;
    }

}
