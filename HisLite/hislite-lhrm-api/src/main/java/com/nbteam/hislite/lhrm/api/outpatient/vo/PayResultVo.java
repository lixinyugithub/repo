package com.nbteam.hislite.lhrm.api.outpatient.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

public class PayResultVo extends BaseResultVo {
    private static final long serialVersionUID = 1L;
    /**
     * 业务订单id
     */
    private Long orderId;
    /**
     * 支付业务类型
     */
    private String orderType;
    /**
     * 支付时间
     */
    private Date payedTime;
    /**
     * 第三方支付流水号
     */
    private String paySerilNo;
    /**
     * 支付类型 WxPay=微信支付
     */
    private String payType;
    /**
     * 支付金额 分
     */
    private Integer totalRealPay;

    /**
     * 获取业务订单id
     * 
     * @return orderId 业务订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置业务订单id
     * 
     * @param orderId 业务订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取支付时间
     * 
     * @return payedTime 支付时间
     */
    public Date getPayedTime() {
        return payedTime;
    }

    /**
     * 设置支付时间
     * 
     * @param payedTime 支付时间
     */
    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    /**
     * 获取第三方支付流水号
     * 
     * @return paySerilNo 第三方支付流水号
     */
    public String getPaySerilNo() {
        return paySerilNo;
    }

    /**
     * 设置第三方支付流水号
     * 
     * @param paySerilNo 第三方支付流水号
     */
    public void setPaySerilNo(String paySerilNo) {
        this.paySerilNo = paySerilNo;
    }

    /**
     * 获取支付类型WxPay=微信支付
     * 
     * @return payType 支付类型WxPay=微信支付
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型WxPay=微信支付
     * 
     * @param payType 支付类型WxPay=微信支付
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取支付金额分
     * 
     * @return totalRealPay 支付金额分
     */
    public Integer getTotalRealPay() {
        return totalRealPay;
    }

    /**
     * 设置支付金额分
     * 
     * @param totalRealPay 支付金额分
     */
    public void setTotalRealPay(Integer totalRealPay) {
        this.totalRealPay = totalRealPay;
    }

    /**
     * 获取支付业务类型
     * 
     * @return orderType 支付业务类型
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置支付业务类型
     * 
     * @param orderType 支付业务类型
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}