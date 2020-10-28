package com.nbteam.hislite.lhrm.api.outpatient.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 隆回 --查询门诊号返回
 *
 */
@XmlRootElement( name="root")
public class FindClinicNoResultVo extends BaseResultVo {
	private static final long serialVersionUID = 1L;
	// 就诊人姓名
	@XmlElement
	private String realName;
	// 就诊人卡号
	@XmlElement
	private String patientCard;
	// 费用生成日期
	@XmlElement
	private String createDate;
	// 开方科室
	@XmlElement
	private String departmentName;
	// 开方科室代码
	@XmlElement
	private String departmentCode;
	// 开方医生
	@XmlElement
	private String doctorName;
	// 开方医生代码
	@XmlElement
	private String doctorCode;
	// 门诊号
	@XmlElement
	private String clinicNo;

	@XmlTransient
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@XmlTransient
	public String getPatientCard() {
		return patientCard;
	}

	public void setPatientCard(String patientCard) {
		this.patientCard = patientCard;
	}
	
	@XmlTransient
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@XmlTransient
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@XmlTransient
	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	@XmlTransient
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	@XmlTransient
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	
	@XmlTransient
	public String getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}

}