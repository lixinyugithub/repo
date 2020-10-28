package com.nbteam.hislite.payment.api.pay.vo;

public class WeixinBaseVo implements java.io.Serializable {
    /** 
     */
    private static final long serialVersionUID = 1L;
    /** 返回code */
    protected String return_code;
    /** 返回说明 */
    protected String return_msg;
    /** 公众账号ID */
    protected String appid;
    /** 商户号 */
    protected String mch_id;
    /** 子商户公众账号ID */
    protected String sub_appid;
    /** 子商户号 */
    protected String sub_mch_id;
    /** 随机字符串 */
    protected String nonce_str;
    /** 签名 */
    protected String sign;
    /** 业务结果 */
    protected String result_code;
    /** 错误代码 */
    protected String err_code;
    /** 错误代码描述 */
    protected String err_code_des;
    /** 设备号 */
    protected String device_info;

    /** {@linkplain #return_code} */
    public String getReturn_code() {
        return return_code;
    }

    /** {@linkplain #return_code} */
    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    /** {@linkplain #return_msg} */
    public String getReturn_msg() {
        return return_msg;
    }

    /** {@linkplain #return_msg} */
    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    /** {@linkplain #appid} */
    public String getAppid() {
        return appid;
    }

    /** {@linkplain #appid} */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /** {@linkplain #mch_id} */
    public String getMch_id() {
        return mch_id;
    }

    /** {@linkplain #mch_id} */
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    /** {@linkplain #sub_appid} */
    public String getSub_appid() {
        return sub_appid;
    }

    /** {@linkplain #sub_appid} */
    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    /** {@linkplain #sub_mch_id} */
    public String getSub_mch_id() {
        return sub_mch_id;
    }

    /** {@linkplain #sub_mch_id} */
    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    /** {@linkplain #nonce_str} */
    public String getNonce_str() {
        return nonce_str;
    }

    /** {@linkplain #nonce_str} */
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    /** {@linkplain #sign} */
    public String getSign() {
        return sign;
    }

    /** {@linkplain #sign} */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /** {@linkplain #result_code} */
    public String getResult_code() {
        return result_code;
    }

    /** {@linkplain #result_code} */
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    /** {@linkplain #err_code} */
    public String getErr_code() {
        return err_code;
    }

    /** {@linkplain #err_code} */
    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    /** {@linkplain #err_code_des} */
    public String getErr_code_des() {
        return err_code_des;
    }

    /** {@linkplain #err_code_des} */
    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    /** {@linkplain #device_info} */
    public String getDevice_info() {
        return device_info;
    }

    /** {@linkplain #device_info} */
    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

}
