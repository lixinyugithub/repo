package com.nbteam.hislite.his.api.inhospital.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Description: 住院缴费订单生成参数<br/>
 *
 */
public class InHospitalParamsVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = -8682197410439334244L;

    /** 医院id */
    @ApiModelProperty("医院id")
    private Long hisId;

    /** 平台id */
    @ApiModelProperty("平台id 1-隆回")
    private Long platformId;

    /**
     * 渠道来源（1-微信 2-支付宝 3-app)
     */
    @ApiModelProperty("渠道来源 8-睿博支付")
    private Integer platformSource;

    /** 价格 */
    @ApiModelProperty("价格")
    private Integer price;

    /** 住院号 */
    @ApiModelProperty("住院号")
    private String admissionNum;

    /** 就诊人名称 */
    @ApiModelProperty("就诊人名称")
    private String patientName;

    /** 就诊卡号 */
    @ApiModelProperty("就诊卡号")
    private String patCardNo;

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(String admissionNum) {
        this.admissionNum = admissionNum;
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

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }
}
