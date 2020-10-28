/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package com.nbteam.hislite.his.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Description: 获取待付款列表参数<br/>
 *
 */
public class PreOppayParamsVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = -8682197410439334244L;

    /** 就诊人名称 */
    @ApiModelProperty("就诊人名称")
    private String patientName;

    /** 就诊卡号 */
    @ApiModelProperty("就诊卡号")
    private String patCardNo;

    /** 平台id */
    @ApiModelProperty("平台id 1-隆回医院")
    private Long platformId;
    /**
     * 渠道来源（1-微信 2-支付宝 3-app)
     */
    @ApiModelProperty("渠道来源 8-睿博支付")
    private Integer platformSource;

    /** 医院id */
    @ApiModelProperty("医院id 1-隆回医院")
    private Long hisId;

    /** 设备号 */
    @ApiModelProperty("devId")
    private String devId;

    @ApiModelProperty("个性化扩展字段")
    private Map<String,Object> extProps;

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

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Map<String, Object> getExtProps() {
        return extProps;
    }

    public void setExtProps(Map<String, Object> extProps) {
        this.extProps = extProps;
    }

}
