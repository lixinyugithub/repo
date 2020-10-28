package com.nbteam.hislite.payment.api.pay.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 
 * 支付通知对象<br/>
 *
 */
public class PayMsgContent implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6446243220015247100L;
    /** FAIL-失败 SUCCESS-成功 */
    private String code;
    /** 失败的消息 */
    private String msg;
    /** 消息类型 {@linkplain} */
    private String type;
    /** 消息体，一般为key-value的json */
    private JSONObject content;

    /** {@linkplain #code} */
    public String getCode() {
        return code;
    }

    /** {@linkplain #code} */
    public void setCode(String code) {
        this.code = code;
    }

    /** {@linkplain #msg} */
    public String getMsg() {
        return msg;
    }

    /** {@linkplain #msg} */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /** {@linkplain #type} */
    public String getType() {
        return type;
    }

    /** {@linkplain #type} */
    public void setType(String type) {
        this.type = type;
    }

    /** {@linkplain #content} */
    public JSONObject getContent() {
        return content;
    }

    /** {@linkplain #content} */
    public void setContent(JSONObject content) {
        this.content = content;
    }

}