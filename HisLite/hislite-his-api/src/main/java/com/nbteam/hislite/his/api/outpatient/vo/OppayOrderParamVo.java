package com.nbteam.hislite.his.api.outpatient.vo;


import com.nbteam.hislite.common.dto.PageParam;

/**
 * 
 * Description: 分页查询参数<br/>
 *
 */
public class OppayOrderParamVo extends PageParam {
    /** 
     */
    private static final long serialVersionUID = -4013804648619568743L;

    /** 门诊缴费id号 */
    private Long id;
    /** 平台id */
    private Long platformId;

    /** 医院订单号 */
    private String hisOrderNo;

    /** 支付类型（wx,aplipay） */
    private String payType;

    /** 支付状态（0-未支付 1-已支付) */
    private Integer payStatus;

    /** 订单状态（U：初始预登记;P：付款完成，调用医院支付接口中;S：付款完成，医院确认成功;F：缴费失败;H：付款完成，医院确认超时或出现故障） */
    private String status;

    /** 退款状态（0-没退款 1-有退款） */
    private Integer refundStatus;
    /** 设备id */
    private String devId;
    /** 用户id */
    private Long userId;
    /** 医院id */
    private Long hisId;
    /** 科室id */
    private String deptId;

    /** 医生id */
    private String doctorId;
    /**
     * 渠道来源（1-微信 2-支付宝 3-app)
     */
    private Integer platformSource;
    /** 就诊人证件id类型（1：二代身份证 2：港澳居民身份证 3：台湾居民身份证 4：护照 ） */
    private Integer patientIdType;
    /** 就诊人证件号 */
    private String patientIdNo;
    /** 卡号码 */
    private String patCardNo;

    private String startTime;//开始时间
    private String endTime;//结束时间

    /** 返回 平台id */
    public Long getPlatformId() {
        return platformId;
    }

    /** 设置 平台id */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHisOrderNo() {
        return hisOrderNo;
    }

    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientIdType() {
        return patientIdType;
    }

    public void setPatientIdType(Integer patientIdType) {
        this.patientIdType = patientIdType;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public String getPatientIdNo() {
        return patientIdNo;
    }

    public void setPatientIdNo(String patientIdNo) {
        this.patientIdNo = patientIdNo;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
