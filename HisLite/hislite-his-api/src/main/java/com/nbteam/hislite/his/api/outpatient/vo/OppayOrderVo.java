package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Description: 门诊订单订单vo<br/>
 *
 */
public class OppayOrderVo implements Serializable {
    /** 
     */
    private static final long serialVersionUID = 5066330037905174064L;

    /** 门诊缴费id号 */
    private Long id;

    /** 平台id */
    private Long platformId;
    /** 医院id */
    private Long hisId;

    /** 医院订单号 */
    private String hisOrderNo;

    /** 支付类型（wx,aplipay） */
    private String payType;

    /** 支付状态（0-未支付 1-已支付) */
    private Integer payStatus;

    /** 订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;S：付款完成，医院确认成功;F：缴费失败;H：付款完成，医院确认超时或出现故障） */
    private String status;

    /** 退款状态（0-没退款 1-有退款） */
    private Integer refundStatus;

    /** 实际支付金额 */
    private Integer totalRealFee;

    /**
     * 医保支付金额
     */
    private Integer medicalFee;

    /** 医院流水号 */
    private String hisSerialNo;

    /** 医院收据号 */
    private String hisRecepitNo;

    /**医院的门诊流水号*/
    private String hisBillNo;

    /**医保标识：0 自费 1 医保 */
    private Integer medicalFlag;

    /** 医保支付参数 */
    private String medicalParam;

    /** 医院退费结算单号 */
    private String hisRefundBalanceNo;

    /** 导诊信息 */
    private String guideInfo;

    /** 是否芝麻信用（0-否 1-是） */
    private Integer isZhima;

    /** 设备id */
    private String devId;

    /** 是否自动退款（0-否 1-是） */
    private Integer isAutoRefund;

    /** 二维码id */
    private String secId;

    /**
     * 订单改变内容
     */
    private String context;
    /**
     * 订单改变详细信息
     */
    private String memo;
    /** 支付时间 */
    private Date payedTime;

    /** 收单机构流水号 */
    private String agtOrdNum;

    /**扩展字段,json各式*/
    private String extFields;

    /**费用类型-各医院自定义*/
    private String chargeType;

    /**处方类型-各医院自定义*/
    private String prescriptionType;

    /** 支付订单号 */
    private Long payOrderId;

    /** 返回 医院id */
    public Long getHisId() {
        return hisId;
    }

    /** 设置 医院id */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** 返回 平台id */
    public Long getPlatformId() {
        return platformId;
    }

    /** 设置 平台id */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /** 返回 收单机构流水号 */
    public String getAgtOrdNum() {
        return agtOrdNum;
    }

    /** 设置 收单机构流水号 */
    public void setAgtOrdNum(String agtOrdNum) {
        this.agtOrdNum = agtOrdNum;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getTotalRealFee() {
        return totalRealFee;
    }

    public void setTotalRealFee(Integer totalRealFee) {
        this.totalRealFee = totalRealFee;
    }

    public String getHisSerialNo() {
        return hisSerialNo;
    }

    public void setHisSerialNo(String hisSerialNo) {
        this.hisSerialNo = hisSerialNo;
    }

    public String getHisRecepitNo() {
        return hisRecepitNo;
    }

    public void setHisRecepitNo(String hisRecepitNo) {
        this.hisRecepitNo = hisRecepitNo;
    }

    public String getHisRefundBalanceNo() {
        return hisRefundBalanceNo;
    }

    public void setHisRefundBalanceNo(String hisRefundBalanceNo) {
        this.hisRefundBalanceNo = hisRefundBalanceNo;
    }

    public String getGuideInfo() {
        return guideInfo;
    }

    public void setGuideInfo(String guideInfo) {
        this.guideInfo = guideInfo;
    }

    public Integer getIsZhima() {
        return isZhima;
    }

    public void setIsZhima(Integer isZhima) {
        this.isZhima = isZhima;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Integer getIsAutoRefund() {
        return isAutoRefund;
    }

    public void setIsAutoRefund(Integer isAutoRefund) {
        this.isAutoRefund = isAutoRefund;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getHisBillNo() {
        return hisBillNo;
    }

    public void setHisBillNo(String hisBillNo) {
        this.hisBillNo = hisBillNo;
    }

    public Integer getMedicalFlag() {
        return medicalFlag;
    }

    public void setMedicalFlag(Integer medicalFlag) {
        this.medicalFlag = medicalFlag;
    }

    public String getMedicalParam() {
        return medicalParam;
    }

    public void setMedicalParam(String medicalParam) {
        this.medicalParam = medicalParam;
    }

    public Integer getMedicalFee() {
        return medicalFee;
    }

    public void setMedicalFee(Integer medicalFee) {
        this.medicalFee = medicalFee;
    }
}
