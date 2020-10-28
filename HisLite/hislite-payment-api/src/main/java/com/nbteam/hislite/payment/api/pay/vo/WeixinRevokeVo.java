package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 微信撤销订单返回数据<br/>
 *
 */
public class WeixinRevokeVo extends WeixinBaseVo {

    /** 
     */
    private static final long serialVersionUID = -7827660008605425873L;
    /** 是否重调 */
    private String reCall;

    /** {@linkplain #reCall} */
    public String getReCall() {
        return reCall;
    }

    /** {@linkplain #reCall} */
    public void setReCall(String reCall) {
        this.reCall = reCall;
    }

}
