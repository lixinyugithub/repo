package com.nbteam.hislite.lhrm.api.outpatient.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 *  隆回 --查询门诊号
 *
 */

@XmlRootElement(name ="request")
public class FindClinicNoParamVo {
    private static final long serialVersionUID = 2777583691030795899L;

    /**
     * 患者姓名
     */
    @XmlElement
    private String realName;

    /**
     * 患者就诊卡号卡号
     */
    @XmlElement
    private String patientCard;
    
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

}