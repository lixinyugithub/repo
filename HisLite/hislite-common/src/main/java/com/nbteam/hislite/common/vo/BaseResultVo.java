package com.nbteam.hislite.common.vo;

import java.io.Serializable;

/**
 * 
 * 结果返回基础对象（所有的resultVo都从这里继承）<br/>
 *
 */
public class BaseResultVo implements Serializable {
    /** 
     */
    private static final long serialVersionUID = 5035286839356949747L;

    /**
     * 调用结果标志 SUCCESS/FAIL
     */
    private String resultCode;

    /**
     * 如果调用失败，返回错误原因
     */
    private String resultMsg;

    private Long startTime = System.currentTimeMillis();

    /** {@linkplain #resultCode} */
    public String getResultCode() {
        return resultCode;
    }

    /** {@linkplain #resultCode} */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /** {@linkplain #resultMsg} */
    public String getResultMsg() {
        return resultMsg;
    }

    /** {@linkplain #resultMsg} */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Long getSpendTime() {
        return System.currentTimeMillis() - this.startTime;
    }

}
