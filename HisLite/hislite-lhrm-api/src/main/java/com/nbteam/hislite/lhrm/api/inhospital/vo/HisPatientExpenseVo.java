package com.nbteam.hislite.lhrm.api.inhospital.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 *
 * Description: 就诊人已预缴的住院费用<br/>
 *
 */
public class HisPatientExpenseVo extends BaseResultVo{

	private static final long serialVersionUID = 1L;
    /** 患者姓名 */
    private String patientName;
    
    /** 已缴押金金额 */
    private String totleAmt;
    
    /** 身份证号 */
    private String idCardNo;
    
    /** 手机号 */
    private String phone;
    
    /** 性别 */
    private String sex;
    
    /** 病区 */
    private String inpatientArea;
    
    /** 住院科室 */
    private String departmentCode;
    
    /** 医生编号 */
    private String doctorCode;
    
    /** 病历号或者其他主键 */
    private String hisNo;
    
    /** 已经使用金额 */
    private String usedAmt;

    /** 剩余金额 */
    private String remainAmt;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getTotleAmt() {
		return totleAmt;
	}

	public void setTotleAmt(String totleAmt) {
		this.totleAmt = totleAmt;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getInpatientArea() {
		return inpatientArea;
	}

	public void setInpatientArea(String inpatientArea) {
		this.inpatientArea = inpatientArea;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getHisNo() {
		return hisNo;
	}

	public void setHisNo(String hisNo) {
		this.hisNo = hisNo;
	}

	public String getUsedAmt() {
		return usedAmt;
	}

	public void setUsedAmt(String usedAmt) {
		this.usedAmt = usedAmt;
	}

	public String getRemainAmt() {
		return remainAmt;
	}

	public void setRemainAmt(String remainAmt) {
		this.remainAmt = remainAmt;
	}

}
