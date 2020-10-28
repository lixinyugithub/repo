/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package com.nbteam.hislite.his.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Description: 门诊缴费订单生成参数<br/>
 *
 */
public class OppayParamsVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = -8682197410439334244L;
    /** 用户ID */
    private Long userId;


    /** 平台id */
    @ApiModelProperty("平台id 1-隆回")
    private Long platformId;
    /**
     * 渠道来源（1-微信 2-支付宝 3-app)
     */
    @ApiModelProperty("渠道来源 8-睿博支付")
    private Integer platformSource;

    /** 就诊人id */
    private Long patientId;

    /** 医院订单id */
    @ApiModelProperty("医院订单号")
    private String hisOrderNo;

    /** 医院id */
    @ApiModelProperty("医院id")
    private Long hisId;

    /** 设备号 */
    @ApiModelProperty("设备号")
    private String devId;

    /** 门诊订单号 */
    @ApiModelProperty("门诊订单号")
    private Long orderId;
    /** 
     * 透传参数 科室名称
     */
    @ApiModelProperty("科室名称")
    private String deptName;
    /** 
     * 透传参数 医生姓名
     */
    @ApiModelProperty("医生姓名")
    private String doctorName;
    
    /** 
     * 个性化扩展字段 目前用在hifond渠道
     * 这些渠道并不是通过就诊人查询代缴费列表的
                    服务代码     serviceCode     N       (webservi接口医院需要)
                    医院代码    branchCode      N       (有的医院需要)
                    卡类型     patCardType     Y        1：院内诊疗卡
                                       2：医保卡
                    卡值      patCardNo       Y         医保卡传电脑号
                    医保卡加密串  SocialSecurityNo        N       
                    卡密码     patCardPwd      N       
                    身份证号    patIdNo N       
                    医保卡保险类型 SocialSecurityType      N       
                    设备号     Dev_id  Y */
    @ApiModelProperty("个性化扩展字段")
    private Map<String,Object> extProps;

    /** 就诊人名称 */
    @ApiModelProperty("就诊人名称")
    private String patientName;

    /** 就诊卡号 */
    @ApiModelProperty("就诊卡号")
    private String patCardNo;
    
    /** 就诊卡号 */
    @ApiModelProperty("就诊卡类型")
    private String patCardType;
    
    /** 就诊卡号 */
    @ApiModelProperty("医院订单号")
    private String patHisNo;
    
    /**  
     * 获取个性化扩展字段目前用在hifond渠道  
     * @return extProps 个性化扩展字段目前用在hifond渠道  
     */
    public Map<String, Object> getExtProps() {
        return extProps;
    }
    
    /**  
     * 设置个性化扩展字段目前用在hifond渠道  
     * @param extProps 个性化扩展字段目前用在hifond渠道  
     */
    public void setExtProps(Map<String, Object> extProps) {
        this.extProps = extProps;
    }
    
    /**  
     * 获取透传参数科室名称  
     * @return deptName 透传参数科室名称  
     */
    public String getDeptName() {
        return deptName;
    }

    /**  
     * 设置透传参数科室名称  
     * @param deptName 透传参数科室名称  
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**  
     * 获取透传参数医生姓名  
     * @return doctorName 透传参数医生姓名  
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**  
     * 设置透传参数医生姓名  
     * @param doctorName 透传参数医生姓名  
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    

    /** 返回 门诊订单号 */
    public Long getOrderId() {
        return orderId;
    }

    /** 设置 门诊订单号 */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /** 返回 设备号 */
    public String getDevId() {
        return devId;
    }

    /** 设置 设备号 */
    public void setDevId(String devId) {
        this.devId = devId;
    }

    /** 返回 医院id */
    public Long getHisId() {
        return hisId;
    }

    /** 设置 医院id */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** 返回 用户ID */
    public Long getUserId() {
        return userId;
    }

    /** 设置 用户ID */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 返回 平台id */
    public Long getPlatformId() {
        return platformId;
    }

    /** 设置 平台id */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    /** 返回 就诊人id */
    public Long getPatientId() {
        return patientId;
    }

    /** 设置 就诊人id */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /** 返回 医院订单id */
    public String getHisOrderNo() {
        return hisOrderNo;
    }

    /** 设置 医院订单id */
    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatCardNo() {
        return patCardNo;
    }

    public void setPatCardNo(String patCardNo) {
        this.patCardNo = patCardNo;
    }

	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	public String getPatHisNo() {
		return patHisNo;
	}

	public void setPatHisNo(String patHisNo) {
		this.patHisNo = patHisNo;
	}
    
    
}
