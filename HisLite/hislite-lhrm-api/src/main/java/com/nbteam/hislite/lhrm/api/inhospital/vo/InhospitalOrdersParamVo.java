package com.nbteam.hislite.lhrm.api.inhospital.vo;

import com.nbteam.hislite.lhrm.api.outpatient.vo.BaseParamVo;

import java.util.Map;

/**
 * 
 *  隆回 --住院
 *
 */
public class InhospitalOrdersParamVo extends BaseParamVo {
    private static final long serialVersionUID = 2777583691030795899L;

    /**
     * 参数
     */
    private Map<String, Object> extProps;

	public Map<String, Object> getExtProps() {
		return extProps;
	}

	public void setExtProps(Map<String, Object> extProps) {
		this.extProps = extProps;
	}
}