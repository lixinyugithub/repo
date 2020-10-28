package com.nbteam.hislite.his.api.inhospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class HisInhospitalOrder implements Serializable {
    @ApiModelProperty("编号")
    private Long inhospitalOrderId;

    @ApiModelProperty("平台编号")
    private Long platformId;

    @ApiModelProperty("医院编号")
    private Long hisId;

    @ApiModelProperty("用户编号")
    private Long userId;

    private Long patientId;

    private String userMobile;

    @ApiModelProperty("（1-微信 2-支付宝 3-app）")
    private Integer platformSource;

    @ApiModelProperty("子渠道")
    private Integer subSource;

    @ApiModelProperty("0->未支付  1->已支付")
    private Integer payStatus;

    @ApiModelProperty("订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;A：订单成功;H：调用医院支付接口异常;Z：调用医院支付接口异常，重发次数超限;C：已取消;）")
    private String status;

    @ApiModelProperty("支付方式参考t_payc_mode_info")
    private String payType;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payedTime;

    @ApiModelProperty("医院流水号")
    private String inhospitalNo;

    @ApiModelProperty("医院名称")
    private String hisName;

    @ApiModelProperty("科室编号")
    private String deptId;

    @ApiModelProperty("住院科室")
    private String deptName;

    @ApiModelProperty("病床号")
    private String bedNo;

    @ApiModelProperty("住院区域")
    private String inhospitalArea;

    @ApiModelProperty("医院交易流水号")
    private String hisOrderNo;

    @ApiModelProperty("支付金额")
    private Integer payFee;

    @ApiModelProperty("收单机构流水号")
    private String acquirerNo;

    @ApiModelProperty("病人姓名")
    private String patientName;

    @ApiModelProperty("病人电话")
    private String patientMobile;

    @ApiModelProperty("证件类型（1-身份证 2-港澳居民身份证 3-台湾居民身份证 4-护照）")
    private Integer idType;

    @ApiModelProperty("证件号")
    private String idNo;

    @ApiModelProperty("医院卡类型")
    private Integer patCardType;

    @ApiModelProperty("医院卡编号")
    private String patCardNo;

    @ApiModelProperty("是否退款状态（0-否 1-是）")
    private Integer refundStatus;

    @ApiModelProperty("住院号")
    private String admissionNum;

    @ApiModelProperty("0.未同步  1.同步成功 2.同步失败 3.同步异常")
    private Integer syncStatus;

    @ApiModelProperty("发送次数")
    private Integer renoticeNum;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("最后修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("失败错误信息")
    private String errorMsg;

    @ApiModelProperty("拓展属性")
    private String extFields;

    @ApiModelProperty("医院流水号")
    private String hisSerialNo;

    @ApiModelProperty("医院收据号")
    private String hisRecepitNo;

    @ApiModelProperty("支付订单号")
    private Long payOrderId;

    @ApiModelProperty("系统类型 0:未知 1：window   2:android")
    private Integer systemType;

    @ApiModelProperty("医院支付状态")
    private String hisStatus;

    @ApiModelProperty("设备id")
    private String devId;

    private static final long serialVersionUID = 1L;

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
        this.userMobile = userMobile;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public Integer getSubSource() {
        return subSource;
    }

    public void setSubSource(Integer subSource) {
        this.subSource = subSource;
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
        this.status = status;
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
        this.inhospitalNo = inhospitalNo;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getInhospitalArea() {
        return inhospitalArea;
    }

    public void setInhospitalArea(String inhospitalArea) {
        this.inhospitalArea = inhospitalArea;
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
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
        this.acquirerNo = acquirerNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
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
        this.patCardNo = patCardNo;
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
        this.admissionNum = admissionNum;
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
        this.errorMsg = errorMsg;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public String getHisSerialNo() {
        return hisSerialNo;
    }

    public void setHisSerialNo(String hisSerialNo) {
        this.hisSerialNo = hisSerialNo;
    }

    public String getHisRecepitNo() {
        return hisRecepitNo;
    }

    public void setHisRecepitNo(String hisRecepitNo) {
        this.hisRecepitNo = hisRecepitNo;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public String getHisStatus() {
        return hisStatus;
    }

    public void setHisStatus(String hisStatus) {
        this.hisStatus = hisStatus;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }
}