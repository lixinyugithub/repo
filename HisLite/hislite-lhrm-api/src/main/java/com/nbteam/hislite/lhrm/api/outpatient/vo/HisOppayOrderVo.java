package com.nbteam.hislite.lhrm.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Description: 代缴费订单<br/>
 *
 */
public class HisOppayOrderVo implements Serializable {

    /** 医院订单号 */
    @ApiModelProperty("prescriptionNo-处方编号")
    private String hisOrderNo;

    /** 医院id */
    @ApiModelProperty("自己回写")
    private Long hisId;

    /** 医院名称 */
    @ApiModelProperty("自己回写")
    private String hisName;

    /** 科室id */
    @ApiModelProperty("departmentName-开方科室代码")
    private String deptId;

    /** 科室名称 */
    @ApiModelProperty("departmentCode-开方科室")
    private String deptName;

    /** 医生id */
    @ApiModelProperty("doctorCode-开方医生代码")
    private String doctorId;

    /** 医生名称 */
    @ApiModelProperty("doctorName-开方医生")
    private String doctorName;

    /** 就诊人名称 */
    @ApiModelProperty("realName-就诊人姓名")
    private String patientName;

    /** 就诊卡号 */
    @ApiModelProperty("patientCard-就诊人卡号")
    private String patCardNo;

    /**患者门诊ID*/
    @ApiModelProperty("clinicNo-门诊号")
    private String patHisNo;

    /** 订单总费用 */
    @ApiModelProperty("orderFee-缴费金额(元转分)")
    private Integer totalFee;

    /**订单实际支付金额*/
    private Integer totalRealFee;

    /** 医保部分金额 */
    private Integer medicalFee;

    /** 自费部分金额 */
    private Integer selfFee;

    /** 缴费单创建时间 */
    @ApiModelProperty("createDate-费用生成日期")
    private Date hisOrderTime;

    /** 付款状态（0-未付款 1-已付款 */
    private Integer payStatus;

    /**费用类型-各医院自定义*/
    @ApiModelProperty("feeType-费用类型")
    private String chargeType;

    /**扩展字段*/
    @ApiModelProperty("扩展字段")
    private String extFields;

    /**
     * 交易结果代码 0-成功 其他都为失败
     */
    private String resultCode;
    /**
     * 当交易结果代码不成功时，该字段必须返回
     */
    private String resultMessage;

    private static final long serialVersionUID = 8425666056490111470L;

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    public String getPatHisNo() {
        return patHisNo;
    }

    public void setPatHisNo(String patHisNo) {
        this.patHisNo = patHisNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getTotalRealFee() {
        return totalRealFee;
    }

    public void setTotalRealFee(Integer totalRealFee) {
        this.totalRealFee = totalRealFee;
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

    public Date getHisOrderTime() {
        return hisOrderTime;
    }

    public void setHisOrderTime(Date hisOrderTime) {
        this.hisOrderTime = hisOrderTime;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }
}
