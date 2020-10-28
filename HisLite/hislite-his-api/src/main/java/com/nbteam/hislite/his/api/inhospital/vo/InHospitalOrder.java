package com.nbteam.hislite.his.api.inhospital.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class InHospitalOrder implements Serializable {
    private static final long serialVersionUID = 5241984841898813363L;
    /** 编号 */
    @ApiModelProperty("编号")
    private Long inhospitalOrderId;

    /** 平台编号 */
    @ApiModelProperty("平台编号")
    private Long platformId;

    /** 医院编号 */
    @ApiModelProperty("医院编号")
    private Long hisId;

    /** 用户编号 */
    private Long userId;

    /**  */
    private Long patientId;

    /**  */
    private String userMobile;

    /** （1-微信 2-支付宝 3-app） */
    @ApiModelProperty("（1-微信 2-支付宝 3-app 8-睿博）")
    private Integer platformSource;

    /** 0->未支付  1->已支付 */
    @ApiModelProperty("0->未支付  1->已支付")
    private Integer payStatus;

    /** 订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;A：订单成功;H：调用医院支付接口异常;Z：调用医院支付接口异常，重发次数超限;C：已取消;） */
    @ApiModelProperty("订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;A：订单成功;H：调用医院支付接口异常;Z：调用医院支付接口异常，重发次数超限;C：已取消;）")
    private String status;

    /** 1-微信 2-支付宝 */
    @ApiModelProperty("支付方式 8-睿博支付")
    private String payType;

    /** 支付时间 */
    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    /** 住院流水号 */
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
    private Integer patCardType;

    /** 医院卡编号 */
    @ApiModelProperty("医院卡编号")
    private String patCardNo;

    /** 是否退款状态（0-否 1-是） */
    private Integer refundStatus;

    /** 住院号 */
    private String admissionNum;

    /** 0.未同步  1.同步成功 2.同步失败 3.同步异常 */
    private Integer syncStatus;

    /** 发送次数 */
    private Integer renoticeNum;

    /** 创建时间 */
    private Date createTime;

    /** 最后修改日期 */
    private Date updateTime;

    /** 失败错误信息 */
    private String errorMsg;

    /** 拓展属性 */
    private String extFields;

    /** 医院流水号 */
    private String hisSerialNo;

    /** 医院收据号 */
    private String hisRecepitNo;

    /** 支付订单号 */
    private Long payOrderId;

    public Long getInhospitalOrderId() {
        return inhospitalOrderId;
    }

    public void setInhospitalOrderId(Long inhospitalOrderId) {
        this.inhospitalOrderId = inhospitalOrderId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
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
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public Integer getPatCardType() {
        return patCardType;
    }

    public void setPatCardType(Integer patCardType) {
        this.patCardType = patCardType;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo == null ? null : patCardNo.trim();
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(String admissionNum) {
        this.admissionNum = admissionNum == null ? null : admissionNum.trim();
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getRenoticeNum() {
        return renoticeNum;
    }

    public void setRenoticeNum(Integer renoticeNum) {
        this.renoticeNum = renoticeNum;
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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields == null ? null : extFields.trim();
    }

    public String getHisSerialNo() {
        return hisSerialNo;
    }

    public void setHisSerialNo(String hisSerialNo) {
        this.hisSerialNo = hisSerialNo == null ? null : hisSerialNo.trim();
    }

    public String getHisRecepitNo() {
        return hisRecepitNo;
    }

    public void setHisRecepitNo(String hisRecepitNo) {
        this.hisRecepitNo = hisRecepitNo == null ? null : hisRecepitNo.trim();
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }
}