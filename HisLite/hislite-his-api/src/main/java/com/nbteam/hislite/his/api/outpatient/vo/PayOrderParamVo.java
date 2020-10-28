package com.nbteam.hislite.his.api.outpatient.vo;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Description: 门诊中心支付下单参数<br/>
 *
 */
public class PayOrderParamVo implements Serializable {
    private static final long serialVersionUID = 3669508933241995209L;
    /**
     * 业务订单号
     */
    @ApiModelProperty("业务订单号 门诊订单号")
    @NotNull(message = "订单id 必填")
    private Long orderId;

    /**
     * 业务类型
     */
    @ApiModelProperty("业务类型 outpatient-门诊业务")
    @NotEmpty(message = "业务类型 必填")
    private String orderType;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户卡号")
    @NotNull(message = "用户卡号 必填")
    private Long userId;

    /** 渠道id(如openId) */
    @ApiModelProperty("用户姓名")
    @NotEmpty(message = "用户姓名 必填")
    private String channelId;

    /**业务信息*/
    @ApiModelProperty("业务信息 alipay-支付宝 wechat-微信")
    @NotEmpty(message = "业务信息 必填")
    private String bizContent;
    /** 
     * 支付方式
     */
    @ApiModelProperty("支付方式 qr-扫码支付")
    @NotEmpty(message = "支付方式 必填")
    private String payMethod;

    @ApiModelProperty("支付渠道 witon-睿博")
    @NotEmpty(message = "支付渠道 必填")
    private String payChannel;
    
    /**  
     * 获取支付方式  
     * @return payMethod 支付方式  
     */
    public String getPayMethod() {
        return payMethod;
    }
    
    /**  
     * 设置支付方式  
     * @param payMethod 支付方式  
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }
}
