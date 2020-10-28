package com.nbteam.hislite.lhrm.api.outpatient.vo;

import java.util.Date;

import com.nbteam.hislite.common.vo.BaseResultVo;

public class QryOppayOrderStatusResultVo extends BaseResultVo {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2403095822778770563L;

	/**
     * 订单主键ID
     */
    private String id;
    
    /**
     * 订单业务主键ID
     */
    private String bizId;
    
	  /**
     * 批单号 
     */
    private String  endorseNo;
    
    /**
     * 订单号 
     */
    private String  tradeNo;
    
    /**
     * 数据来源 
     */
    private String   dataSrc;
    
    /**
     * 用户ID 
     */
    private String  customerId;
    
    /**
     * 医院ID  
     */
    private String  hospitalId;
    /**
     * 就诊人ID  
     */
    private String  patientId;
    /**
     * 就诊人名称   
     */
    private String  patientName;
    /**
     * 订单金额  
     */
    private String  orderAmount;
    
    /**
     * 订单状态   
     */
    private String  orderStatus;
    
    /**
     * 缴费类型  
     */
   private String  feeType;
    /**
     * 支付类型 
     */
    private String  payType;
    /**
     * 缴费日期  
     */
    private String  feeDate ;
    /**
     * 订单更新日期  
     */
    private String  updateTime;
    
    /**
     * 订单创建日期   
     */
    private String  createTime ;
    /**
     * 订单更新日期  
     */
    private String  hisStatus;
    
    /**
     * 就诊人身份证号  
     */
    private String  idCard;
          
    /** 签名字段 */
    private String sign;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getDataSrc() {
		return dataSrc;
	}

	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getHisStatus() {
		return hisStatus;
	}

	public void setHisStatus(String hisStatus) {
		this.hisStatus = hisStatus;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	} 

}
