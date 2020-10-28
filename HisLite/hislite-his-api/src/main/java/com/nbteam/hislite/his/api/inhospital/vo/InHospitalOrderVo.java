package com.nbteam.hislite.his.api.inhospital.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class InHospitalOrderVo implements Serializable {

    private static final long serialVersionUID = -7305829166593131339L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long inhospitalOrderId;

    /**  */
    @ApiModelProperty("医院编号")
    private Long hisId;

    /**  */
    private Long userId;

    /**  */
    private Long patientId;

    /**  */
    private String userMobile;

    /** （1-微信 2-支付宝 3-app） */
    @ApiModelProperty("（1-微信 2-支付宝 3-app 8-睿博）")
    private Integer platformSource;

    /**
     * 1：未付费 2：已付费 3：已关闭
     */
    @ApiModelProperty("0->未支付  1->已支付")
    private Integer payStatus;

    /** 1-微信 2-支付宝 */
    @ApiModelProperty("支付方式 8-睿博支付")
    private String payType;

    /** 支付时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    /** 住院编号 */
    private String inhospitalNo;

    /** 医院名称 */
    private String hisName;

    /** 科室编号 */
    private String deptId;

    /** 住院科室 */
    private String deptName;

    /** 病床号 */
    private String bedNo;

    /** 住院区域 */
    private String inhospitalArea;

    /** 医院交易流水号 */
    @ApiModelProperty("医院交易流水号")
    private String hisOrderNo;

    /** 支付金额 */
    @ApiModelProperty("支付金额")
    private Integer payFee;

    /** 收单机构流水号 */
    private String acquirerNo;

    /** 病人姓名 */
    @ApiModelProperty("病人姓名")
    private String patientName;

    /** 病人电话 */
    private String patientMobile;

    /** 证件类型（1-身份证 2-港澳居民身份证 3-台湾居民身份证 4-护照） */
    private Integer idType;

    /** 证件号 */
    private String idNo;

    /** 医院卡类型 */
    private Integer hisCardType;

    /** 医院卡编号 */
    private String hisCardNo;
    
    /** 费用类型 */
    private String bizType;

    /**业务信息*/
    @ApiModelProperty("(特别注意下)新增业务信息 alipay-支付宝 wechat-微信")
    private String bizContent;

    /** 创建时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 修改时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 住院号
     */
    private String admissionNum;

    private String status;

    /** 是否退款状态（0-否 1-是） */
    private Integer refundStatus;

    @ApiModelProperty("医院卡编号")
    private String patCardNo;

    private Integer patCardType;

    public Long getInhospitalOrderId() {
        return inhospitalOrderId;
    }

    public void setInhospitalOrderId(Long inhospitalOrderId) {
        this.inhospitalOrderId = inhospitalOrderId;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    public Integer getPatCardType() {
        return patCardType;
    }

    public void setPatCardType(Integer patCardType) {
        this.patCardType = patCardType;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
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

    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo == null ? null : inhospitalNo.trim();
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName == null ? null : hisName.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public String getInhospitalArea() {
        return inhospitalArea;
    }

    public void setInhospitalArea(String inhospitalArea) {
        this.inhospitalArea = inhospitalArea == null ? null : inhospitalArea.trim();
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo == null ? null : hisOrderNo.trim();
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public String getAcquirerNo() {
        return acquirerNo;
    }

    public void setAcquirerNo(String acquirerNo) {
        this.acquirerNo = acquirerNo == null ? null : acquirerNo.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile == null ? null : patientMobile.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getHisCardType() {
        return hisCardType;
    }

    public void setHisCardType(Integer hisCardType) {
        this.hisCardType = hisCardType;
    }

    public String getHisCardNo() {
        return hisCardNo;
    }

    public void setHisCardNo(String hisCardNo) {
        this.hisCardNo = hisCardNo == null ? null : hisCardNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(String admissionNum) {
        this.admissionNum = admissionNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }
    
    public String getBizType() {
        return bizType;
    }
    
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }
}