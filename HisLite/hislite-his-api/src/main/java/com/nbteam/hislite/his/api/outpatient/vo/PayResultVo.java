package com.nbteam.hislite.his.api.outpatient.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Description: 支付结果<br/>
 *
 */
public class PayResultVo implements Serializable {
    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1010465975317215840L;

    /**
     * 订单支付状态（0-成功 其他为失败）
     */
    @ApiModelProperty("订单支付状态 0-成功")
    private String code;
    /**
     * 当code非0时，此值必填
     */
    private String msg;
    /**
     * 订单id 必填
     */
    @ApiModelProperty("订单id 必填")
    @NotNull(message = "订单id 必填")
    private Long orderId;
    /**
     * 订单类型 必填
     */
    @ApiModelProperty("订单类型 outpatient-门诊")
    private String orderType;
    /**
     * 支付类型 微信还是支付宝或其他
     */
    @ApiModelProperty("支付类型 alipay-支付宝 wechat-微信")
    private String payType;

    /**
     * 支付流水
     */
    @ApiModelProperty("支付流水号")
    @NotEmpty(message = "支付流水号 必填")
    private String paySerilNo;

    /**
     * 实际支付金额
     */
    @ApiModelProperty("实际支付金额 单位:分")
    private Integer totalRealPay;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    @NotNull(message = "支付时间 必填")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;
    /**
     * 医保标识：1-自费 2-全医保 3-医保+自费
     */
    private Integer medicalFlag;
    /**
     * 医保金额
     */
    private Integer medicareFee;
    /**
     * 自费金额
     */
    private Integer selfFee;

    /**
     * 诊疗证编号
     */
    private String medicalCardId;
    /**
     * 医疗机构编码
     */
    private String orgNo;

    /** 
     * 渠道用户id
     */  
    private String openId;
    
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPaySerilNo() {
        return paySerilNo;
    }

    public void setPaySerilNo(String paySerilNo) {
        this.paySerilNo = paySerilNo;
    }

    public Integer getTotalRealPay() {
        return totalRealPay;
    }

    public void setTotalRealPay(Integer totalRealPay) {
        this.totalRealPay = totalRealPay;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getMedicareFee() {
        return medicareFee;
    }

    public void setMedicareFee(Integer medicareFee) {
        this.medicareFee = medicareFee;
    }

    public Integer getSelfFee() {
        return selfFee;
    }

    public void setSelfFee(Integer selfFee) {
        this.selfFee = selfFee;
    }

    public String getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(String medicalCardId) {
        this.medicalCardId = medicalCardId;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Integer getMedicalFlag() {
        return medicalFlag;
    }

    public void setMedicalFlag(Integer medicalFlag) {
        this.medicalFlag = medicalFlag;
    }
    
    
}
