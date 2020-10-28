package com.nbteam.hislite.lhrm.api.outpatient.vo;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
/**
 * 
 * 参数基础类（所有的voparam都继承这个类）<br/>
 *
 */
public class BaseResultVo implements Serializable {

    /** 
     */  
    private static final long serialVersionUID = -6381198117476248523L;

    /** 返回code(success/error) */
    @NotNull(message = "接口返回结果")
    private String resultCode;
    
    /** 错误原因 */
    @NotNull(message = "接口返回说明")
    private String resultMessage;

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
    
}
