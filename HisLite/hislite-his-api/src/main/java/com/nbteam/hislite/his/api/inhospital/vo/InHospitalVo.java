/**
 * 
 */
package com.nbteam.hislite.his.api.inhospital.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 */
public class InHospitalVo implements Serializable {
    private static final long serialVersionUID = -3582606054324809769L;

    /** 医院卡号类型 */
    private Integer hisCardType;
    /** 医院卡号id */
    private String hisCardNo;
    /** 标志（1-默认就诊人） */
    private Integer isDefalut;
    /** 业务类型（1-门诊 2-住院 4-体检 按照这个组合值） */
    private String channelType;
    /** 与本人关系id */
    private Integer relationType;
    /** 关系名称 */
    private String relationName;
    private Long hisId;
    private String hisName;
    private Long patientId;
    @ApiModelProperty("就诊人名称")
    private String patientName;
    private String admissionNum;
    private String inhospitalNo;
    @ApiModelProperty("住院科室")
    private String deptName;
    private String deptNo;
    private String bedNo;
    @ApiModelProperty("已缴押金金额")
    private Integer totalFee;
    @ApiModelProperty("剩余金额")
    private Integer balance;
    @ApiModelProperty("已使用金额")
    private Integer consumeFee;
    @ApiModelProperty("0出院;1在院")
    private String status;
    @ApiModelProperty("入院日期")
    private String inDate;
    @ApiModelProperty("出院日期")
    private String outDate;
    @ApiModelProperty("病历号或者其他主键")
    private String patCardNo;
    private Integer patCardType;
    
    /** 住院病区 */
    @ApiModelProperty("住院病区")
    private String admissionWard;
    
    /** 病床医生 */
    private String doctorName;
    @ApiModelProperty("责任医生代码")
    private String doctoerNo;
    
    private String otherDesc;
    @ApiModelProperty("身份证号码")
    private String idNo;
    private Integer idType;
    private String inhospitalRecordId;
    @ApiModelProperty("电话号码")
    private String mobile;

    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDoctoerNo() {
        return doctoerNo;
    }

    public void setDoctoerNo(String doctoerNo) {
        this.doctoerNo = doctoerNo;
    }

    public Integer getHisCardType() {
        return hisCardType;
    }

    public void setHisCardType(Integer hisCardType) {
        this.hisCardType = hisCardType;
    }

    public String getHisCardNo() {
        return hisCardNo;
    }

    public void setHisCardNo(String hisCardNo) {
        this.hisCardNo = hisCardNo;
    }

    public Integer getIsDefalut() {
        return isDefalut;
    }

    public void setIsDefalut(Integer isDefalut) {
        this.isDefalut = isDefalut;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(String admissionNum) {
        this.admissionNum = admissionNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getConsumeFee() {
        return consumeFee;
    }

    public void setConsumeFee(Integer consumeFee) {
        this.consumeFee = consumeFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    public Integer getPatCardType() {
        return patCardType;
    }

    public void setPatCardType(Integer patCardType) {
        this.patCardType = patCardType;
    }

    public String getAdmissionWard() {
        return admissionWard;
    }

    public void setAdmissionWard(String admissionWard) {
        this.admissionWard = admissionWard;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getInhospitalRecordId() {
        return inhospitalRecordId;
    }

    public void setInhospitalRecordId(String inhospitalRecordId) {
        this.inhospitalRecordId = inhospitalRecordId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
