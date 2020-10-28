package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Description: 订单状态改变接口<br/>
 *
 */
public class OrderStatusChangeVo implements Serializable {
    /** 
     */
    private static final long serialVersionUID = -1734512196566444406L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 支付状态
     */
    private Integer payStatus;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 支付时间
     */
    private Date payedTime;
    /**
     * 实际支付金额
     */
    private Integer totalRealFee;
    /**
     * 操作人id号
     */
    private String operator;
    /**
     * 操作角色
     */
    private String operatorRole;

    /**
     * 结果状态
     */
    private String memo;

    /** 收单机构流水号 */
    private String agtOrdNum;

    /**
     * 医保金额
     */
    private Integer medicareFee;
    /**
     * 自费金额
     */
    private Integer selfFee;

    /** 扩展字段 */
    private String extFields;

    /**
     * 医保标识：0 自费 1 医保
     */
    private Integer medicalFlag;


    /** 返回 收单机构流水号 */
    public String getAgtOrdNum() {
        return agtOrdNum;
    }

    /** 设置 收单机构流水号 */
    public void setAgtOrdNum(String agtOrdNum) {
        this.agtOrdNum = agtOrdNum;
    }

    /** 返回 订单状态 */
    public String getStatus() {
        return status;
    }

    /** 设置 订单状态 */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public Integer getTotalRealFee() {
        return totalRealFee;
    }

    public void setTotalRealFee(Integer totalRealFee) {
        this.totalRealFee = totalRealFee;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorRole() {
        return operatorRole;
    }

    public void setOperatorRole(String operatorRole) {
        this.operatorRole = operatorRole;
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

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public Integer getMedicalFlag() {
        return medicalFlag;
    }

    public void setMedicalFlag(Integer medicalFlag) {
        this.medicalFlag = medicalFlag;
    }
}
