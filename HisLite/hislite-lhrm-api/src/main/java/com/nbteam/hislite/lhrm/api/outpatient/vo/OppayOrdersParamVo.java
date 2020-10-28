package com.nbteam.hislite.lhrm.api.outpatient.vo;

import java.util.Map;

/**
 * 
 *  隆回 --查询门诊待缴费列表
 *
 */
public class OppayOrdersParamVo extends BaseParamVo {
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