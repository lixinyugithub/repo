package com.nbteam.hislite.lhrm.api.inhospital.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;
import java.util.Map;

public class InHosputalHisResultVo extends BaseResultVo {
    private static final long serialVersionUID = 1L;

    /**
     * 医院回执编号
     */
    private String hisRecepitNo;

    /**
     * 扩展字段
     */
    private Map<String, Object> extFields;
    /**
     * 医院流水号
     */
    private String hisSerialNo;

    /** 导诊信息 */
    private String guideInfo;

    public String getHisRecepitNo() {
        return hisRecepitNo;
    }

    public void setHisRecepitNo(String hisRecepitNo) {
        this.hisRecepitNo = hisRecepitNo;
    }

    public Map<String, Object> getExtFields() {
        return extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }

    public String getHisSerialNo() {
        return hisSerialNo;
    }

    public void setHisSerialNo(String hisSerialNo) {
        this.hisSerialNo = hisSerialNo;
    }

    public String getGuideInfo() {
        return guideInfo;
    }

    public void setGuideInfo(String guideInfo) {
        this.guideInfo = guideInfo;
    }
}