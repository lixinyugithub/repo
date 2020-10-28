package com.nbteam.hislite.payment.api.pay.vo;

import java.io.Serializable;

/**
 * 
 * 二维码对象模型<br/>
 *
 */
public class QrResultVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = 8100606330990133474L;

    /** 支付渠道 */
    private String payChannel;
    /** 二维码内容 */
    private String qrContent;

    /** {@linkplain #payChannel} */
    public String getPayChannel() {
        return payChannel;
    }

    /** {@linkplain #payChannel} */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    /** {@linkplain #qrContent} */
    public String getQrContent() {
        return qrContent;
    }

    /** {@linkplain #qrContent} */
    public void setQrContent(String qrContent) {
        this.qrContent = qrContent;
    }

}
