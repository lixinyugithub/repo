package com.nbteam.hislite.lhrm.api.outpatient.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class HospitalOppayOrder implements Serializable {
    @ApiModelProperty("门诊缴费id号")
    private Long id;

    @ApiModelProperty("平台id")
    private Long platformId;

    @ApiModelProperty("医院订单号")
    private String hisOrderNo;

    @ApiModelProperty("缴费项目名称")
    private String name;

    @ApiModelProperty("医院id")
    private Long hisId;

    @ApiModelProperty("科室id")
    private String deptId;

    @ApiModelProperty("医生id")
    private String doctorId;

    @ApiModelProperty("医院名称")
    private String hisName;

    @ApiModelProperty("科室名称")
    private String deptName;

    @ApiModelProperty("医生名称")
    private String doctorName;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("就诊人Id")
    private Long patientId;

    @ApiModelProperty("支付方式参考t_payc_mode_info")
    private String payType;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    @ApiModelProperty("收单机构流水号")
    private String agtOrdNum;

    @ApiModelProperty("是否已支付（0-否 1-是）")
    private Integer payStatus;

    @ApiModelProperty("渠道来源（1-微信 2-支付宝 3-app)")
    private Integer platformSource;

    @ApiModelProperty("子渠道")
    private Integer subSource;

    @ApiModelProperty("订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;S：付款完成，医院确认成功;F：缴费失败;H：付款完成，医院确认超时或出现故障）")
    private String status;

    @ApiModelProperty("退款状态（0-没退款 1-有退款）")
    private Integer refundStatus;

    @ApiModelProperty("实际支付金额")
    private Integer totalRealFee;

    @ApiModelProperty("订单总金额")
    private Integer totalFee;

    @ApiModelProperty("就诊人名称")
    private String patientName;

    @ApiModelProperty("就诊人证件id类型（1：二代身份证 2：港澳居民身份证 3：台湾居民身份证 4：护照 ）")
    private Integer patientIdType;

    @ApiModelProperty("就诊人证件号")
    private String patientIdNo;

    @ApiModelProperty("就诊人性别")
    private String patientSex;

    @ApiModelProperty("就诊人年龄")
    private Integer patientAge;

    @ApiModelProperty("就诊人电话号码")
    private String patientMobile;

    @ApiModelProperty("医院流水号")
    private String hisSerialNo;

    @ApiModelProperty("医院收据号")
    private String hisRecepitNo;

    @ApiModelProperty("就诊卡类型")
    private String patCardType;

    @ApiModelProperty("就诊卡号码")
    private String patCardNo;

    @ApiModelProperty("医院退费结算单号")
    private String hisRefundBalanceNo;

    @ApiModelProperty("导诊信息")
    private String guideInfo;

    @ApiModelProperty("医保支付金额")
    private Integer medicalFee;

    @ApiModelProperty("个人支付金额")
    private Integer selfFee;

    @ApiModelProperty("医保就诊登记号")
    private String medRegisterNo;

    @ApiModelProperty("是否芝麻信用（0-否 1-是）")
    private Integer isZhima;

    @ApiModelProperty("设备id")
    private String devId;

    @ApiModelProperty("是否自动退款（0-否 1-是）")
    private Integer isAutoRefund;

    @ApiModelProperty("二维码id")
    private String secId;

    @ApiModelProperty("医院门诊订单开单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hisOrderTime;

    @ApiModelProperty("费用类型-各医院自定义")
    private String chargeType;

    @ApiModelProperty("处方类型-各医院自定义")
    private String prescriptionType;

    @ApiModelProperty("父医院ID")
    private Long parentHisId;

    @ApiModelProperty("就诊人门诊ID")
    private String patHisNo;

    @ApiModelProperty("扩展字段,json格式")
    private String extFields;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("支付订单号")
    private Long payOrderId;

    @ApiModelProperty("医院的门诊流水号")
    private String hisBillNo;

    @ApiModelProperty("医保支付参数")
    private String medicalParam;

    @ApiModelProperty("医保标识：1-自费 2-全医保 3-医保+自费")
    private Integer medicalFlag;

    @ApiModelProperty("错误信息")
    private String errorMsg;

    @ApiModelProperty("系统类型 0:未知 1：window   2:android")
    private Integer systemType;

    @ApiModelProperty("商户订单号")
    private String merchantOrderId;

    @ApiModelProperty("医院支付状态")
    private String hisStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public String getAgtOrdNum() {
        return agtOrdNum;
    }

    public void setAgtOrdNum(String agtOrdNum) {
        this.agtOrdNum = agtOrdNum;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public Integer getSubSource() {
        return subSource;
    }

    public void setSubSource(Integer subSource) {
        this.subSource = subSource;
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientIdType() {
        return patientIdType;
    }

    public void setPatientIdType(Integer patientIdType) {
        this.patientIdType = patientIdType;
    }

    public String getPatientIdNo() {
        return patientIdNo;
    }

    public void setPatientIdNo(String patientIdNo) {
        this.patientIdNo = patientIdNo;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
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

    public String getPatCardType() {
        return patCardType;
    }

    public void setPatCardType(String patCardType) {
        this.patCardType = patCardType;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
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

    public Integer getMedicalFee() {
        return medicalFee;
    }

    public void setMedicalFee(Integer medicalFee) {
        this.medicalFee = medicalFee;
    }

    public Integer getSelfFee() {
        return selfFee;
    }

    public void setSelfFee(Integer selfFee) {
        this.selfFee = selfFee;
    }

    public String getMedRegisterNo() {
        return medRegisterNo;
    }

    public void setMedRegisterNo(String medRegisterNo) {
        this.medRegisterNo = medRegisterNo;
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

    public Date getHisOrderTime() {
        return hisOrderTime;
    }

    public void setHisOrderTime(Date hisOrderTime) {
        this.hisOrderTime = hisOrderTime;
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

    public Long getParentHisId() {
        return parentHisId;
    }

    public void setParentHisId(Long parentHisId) {
        this.parentHisId = parentHisId;
    }

    public String getPatHisNo() {
        return patHisNo;
    }

    public void setPatHisNo(String patHisNo) {
        this.patHisNo = patHisNo;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getMedicalParam() {
        return medicalParam;
    }

    public void setMedicalParam(String medicalParam) {
        this.medicalParam = medicalParam;
    }

    public Integer getMedicalFlag() {
        return medicalFlag;
    }

    public void setMedicalFlag(Integer medicalFlag) {
        this.medicalFlag = medicalFlag;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getHisStatus() {
        return hisStatus;
    }

    public void setHisStatus(String hisStatus) {
        this.hisStatus = hisStatus;
    }
}