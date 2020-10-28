package com.nbteam.hislite.his.api.inhospital.vo;

import java.io.Serializable;

/**
 * Description: 二维码对象模型
 *
 */
public class QrQueryResultVo implements Serializable {
    private static final long serialVersionUID = -5401596812628108807L;
    /**
     * 支付渠道
     */
    private String payChannel;
    /**
     * 二维码内容
     */
    private String qrContent;

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getQrContent() {
        return qrContent;
    }

    public void setQrContent(String qrContent) {
        this.qrContent = qrContent;
    }
}
