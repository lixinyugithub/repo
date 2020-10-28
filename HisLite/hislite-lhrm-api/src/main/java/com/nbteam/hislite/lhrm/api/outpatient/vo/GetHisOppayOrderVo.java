package com.nbteam.hislite.lhrm.api.outpatient.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Description: 代缴费订单<br/>
 *
 */
public class GetHisOppayOrderVo implements Serializable {

	private static final long serialVersionUID = 8425666056490111470L;
    /**
     * 交易结果代码 0-成功 其他都为失败
     */
    private String resultCode;
    /**
     * 当交易结果代码不成功时，该字段必须返回
     */
    private String resultMessage;

    private List<HisOppayOrderVo> itemList;

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

	public List<HisOppayOrderVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<HisOppayOrderVo> itemList) {
		this.itemList = itemList;
	}
    
}
