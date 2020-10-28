package com.nbteam.hislite.his.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * Description: 代缴费订单<br/>
 *
 */
public class WaitPayOrderVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = 117461829652776573L;
    /** 医院订单号 */
    @ApiModelProperty("医院订单号")
    private String hisOrderNo;
    /** 医院流水 */
    private String hisSerilNo;
    /**医院收据号*/
    private String hisRecepitNo;
    /**医院的门诊流水号*/
    private String hisBillNo;
    /**是否是医保订单：0 自费 1 医保 */
    private Integer medicalFlag;
    /** 医保参数 */
    private String medicalParam;
    /** 医院id */
    @ApiModelProperty("医院id")
    private Long hisId;
    /** 医院名称 */
    @ApiModelProperty("医院名称")
    private String hisName;
    /** 缴费单名称 */
    private String name;
    /** 科室id */
    @ApiModelProperty("科室id")
    private String deptId;
    /** 科室名称 */
    @ApiModelProperty("科室名称")
    private String deptName;
    /** 医生id */
    @ApiModelProperty("医生id")
    private String doctorId;
    /** 医生名称 */
    @ApiModelProperty("医生名称")
    private String doctorName;
    /** 医生职称 */
    private String doctorTitle;
    /** 就诊人ID */
    private Long patientId;
    /** 就诊人名称 */
    @ApiModelProperty("就诊人名称")
    private String patientName;
    /** 就诊卡号 */
    @ApiModelProperty("就诊卡号")
    private String patCardNo;
    /** 就诊卡类型 */
    private Integer patCardType;
    /**患者门诊ID*/
    @ApiModelProperty("患者门诊ID")
    private String patHisNo;
    /** 订单总费用 */
    @ApiModelProperty("订单总费用")
    private Integer totalFee;
    /**订单实际支付金额*/
    private Integer totalRealFee;
    /** 医保部分金额 */
    private Integer medicalFee;
    /** 自费部分金额 */
    private Integer selfFee;
    /** 缴费单创建时间 */
    @ApiModelProperty("缴费单创建时间")
    private Date hisOrderTime;
    /** 付款状态（0-未付款 1-已付款 */
    private Integer payStatus;
    /** 导诊信息 */
    private String guideInfo;
    /** 医保就诊登记号 */
    private String medRegisterNo;
    /**费用类型-各医院自定义*/
    @ApiModelProperty("费用类型")
    private String chargeType;
    /**处方类型-各医院自定义*/
    private String prescriptionType;
    /** 缴费订单详情 */
    private List<WaitPayOrderItemVo> itemList;
    /** 扩展字段 **/
    private String extFields;

    /** 返回 医生职称 */
    public String getDoctorTitle() {
        return doctorTitle;
    }

    /** 设置 医生职称 */
    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }

    /** 返回 就诊人ID */
    public Long getPatientId() {
        return patientId;
    }

    /** 设置 就诊人ID */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /** 返回 就诊人名称 */
    public String getPatientName() {
        return patientName;
    }

    /** 设置 就诊人名称 */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /** 返回 就诊卡号 */
    public String getPatCardNo() {
        return patCardNo;
    }

    /** 设置 就诊卡号 */
    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    /** 返回 医院id */
    public Long getHisId() {
        return hisId;
    }

    /** 设置 医院id */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** 返回 医院名称 */
    public String getHisName() {
        return hisName;
    }

    /** 设置 医院名称 */
    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public String getGuideInfo() {
        return guideInfo;
    }

    public void setGuideInfo(String guideInfo) {
        this.guideInfo = guideInfo;
    }

    public String getMedRegisterNo() {
        return medRegisterNo;
    }

    public void setMedRegisterNo(String medRegisterNo) {
        this.medRegisterNo = medRegisterNo;
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getPatCardType() {
        return patCardType;
    }

    public void setPatCardType(Integer patCardType) {
        this.patCardType = patCardType;
    }

    public String getPatHisNo() {
        return patHisNo;
    }

    public void setPatHisNo(String patHisNo) {
        this.patHisNo = patHisNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getTotalRealFee() {
        return totalRealFee;
    }

    public void setTotalRealFee(Integer totalRealFee) {
        this.totalRealFee = totalRealFee;
    }

    public Integer getMedicalFee() {
        return medicalFee;
    }

    public void setMedicalFee(Integer medicalFee) {
        this.medicalFee = medicalFee;
    }

    public Integer getSelfFee() {
        return selfFee;
    }

    public void setSelfFee(Integer selfFee) {
        this.selfFee = selfFee;
    }

    public Date getHisOrderTime() {
        return hisOrderTime;
    }

    public void setHisOrderTime(Date hisOrderTime) {
        this.hisOrderTime = hisOrderTime;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public List<WaitPayOrderItemVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<WaitPayOrderItemVo> itemList) {
        this.itemList = itemList;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public String getHisSerilNo() {
        return hisSerilNo;
    }

    public void setHisSerilNo(String hisSerilNo) {
        this.hisSerilNo = hisSerilNo;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public String getHisRecepitNo() {
        return hisRecepitNo;
    }

    public void setHisRecepitNo(String hisRecepitNo) {
        this.hisRecepitNo = hisRecepitNo;
    }

    public String getHisBillNo() {
        return hisBillNo;
    }

    public void setHisBillNo(String hisBillNo) {
        this.hisBillNo = hisBillNo;
    }

    public Integer getMedicalFlag() {
        return medicalFlag;
    }

    public void setMedicalFlag(Integer medicalFlag) {
        this.medicalFlag = medicalFlag;
    }

    public String getMedicalParam() {
        return medicalParam;
    }

    public void setMedicalParam(String medicalParam) {
        this.medicalParam = medicalParam;
    }
}
