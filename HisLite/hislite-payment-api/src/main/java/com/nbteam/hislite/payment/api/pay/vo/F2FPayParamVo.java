package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 当面付支付参数<br/>
 *
 * @author fuxinwang
 * @version 1.0
 * @date: 2017年03月04日 20:30
 * @since JDK 1.7
 */
public class F2FPayParamVo extends UnifiedOrderParamVo {
    private static final long serialVersionUID = 1L;

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB" 网页支付或者公众号支付可为空
     */
    private String deviceInfo;

    /**
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 选填
     */
    private String attach;
    /**
     * 支付授权码 必填
     */
    private String authCode;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}