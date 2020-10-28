package com.nbteam.hislite.lhrm.api.outpatient.vo;

/**
 * 
 *  隆回 --查询门诊待缴费列表
 *
 */
public class GetOppayListParamVo extends BaseParamVo {
    private static final long serialVersionUID = 2777583691030795899L;

    /**
     * 患者姓名
     */
    private String realName;

    /**
     * 患者就诊卡号卡号
     */
    private String patientCard;
    
    /**
     * 门诊号
     */
    private String clinicNo;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPatientCard() {
		return patientCard;
	}

	public void setPatientCard(String patientCard) {
		this.patientCard = patientCard;
	}

	public String getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}

}