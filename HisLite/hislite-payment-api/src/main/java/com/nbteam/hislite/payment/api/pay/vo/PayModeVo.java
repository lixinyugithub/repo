package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;

/**
 * 
 * 支付方式输出参数<br/>
 *
 */
public class PayModeVo implements Serializable {
    /** 
     */
    private static final long serialVersionUID = -6002410236138770959L;

    /** 支付方式（支付渠道+支付方法） */
    private String payMode;

    /** 支付模式名称 */
    private String payModeName;

    /** 支付log url */
    private String logoUri;

    /** 支付模式说明 */
    private String remark;

    /** {@linkplain #payMode} */
    public String getPayMode() {
        return payMode;
    }

    /** {@linkplain #payMode} */
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    /** {@linkplain #payModeName} */
    public String getPayModeName() {
        return payModeName;
    }

    /** {@linkplain #payModeName} */
    public void setPayModeName(String payModeName) {
        this.payModeName = payModeName;
    }

    /** {@linkplain #logoUri} */
    public String getLogoUri() {
        return logoUri;
    }

    /** {@linkplain #logoUri} */
    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    /** {@linkplain #remark} */
    public String getRemark() {
        return remark;
    }

    /** {@linkplain #remark} */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
