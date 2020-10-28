package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.List;

/**
 * 
 * 支付方式返回列表<br/>
 *
 */
public class QueryModeResultVo extends BaseResultVo {

    /** 
     */
    private static final long serialVersionUID = 5294776218163463459L;

    private String payOrderId;

    private String hisName;

    private String goodsName;

    private Integer totalFee;

    private Integer medicareFee;

    private boolean medicareFlag;

    private Integer selfFee;

    private Integer leftPayTime;

    private List<PayModeVo> payModeList;

    /** {@linkplain #medicareFee} */
    public Integer getMedicareFee() {
        return medicareFee;
    }

    /** {@linkplain #medicareFee} */
    public void setMedicareFee(Integer medicareFee) {
        this.medicareFee = medicareFee;
    }

    /** {@linkplain #medicareFlag} */
    public boolean isMedicareFlag() {
        return medicareFlag;
    }

    /** {@linkplain #medicareFlag} */
    public void setMedicareFlag(boolean medicareFlag) {
        this.medicareFlag = medicareFlag;
    }

    /** {@linkplain #selfFee} */
    public Integer getSelfFee() {
        return selfFee;
    }

    /** {@linkplain #selfFee} */
    public void setSelfFee(Integer selfFee) {
        this.selfFee = selfFee;
    }

    /** {@linkplain #leftPayTime} */
    public Integer getLeftPayTime() {
        return leftPayTime;
    }

    /** {@linkplain #leftPayTime} */
    public void setLeftPayTime(Integer leftPayTime) {
        this.leftPayTime = leftPayTime;
    }

    /** {@linkplain #totalFee} */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** {@linkplain #payOrderId} */
    public String getPayOrderId() {
        return payOrderId;
    }

    /** {@linkplain #payOrderId} */
    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    /** {@linkplain #hisName} */
    public String getHisName() {
        return hisName;
    }

    /** {@linkplain #hisName} */
    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    /** {@linkplain #goodsName} */
    public String getGoodsName() {
        return goodsName;
    }

    /** {@linkplain #goodsName} */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** {@linkplain #totalFee} */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** {@linkplain #payModeList} */
    public List<PayModeVo> getPayModeList() {
        return payModeList;
    }

    /** {@linkplain #payModeList} */
    public void setPayModeList(List<PayModeVo> payModeList) {
        this.payModeList = payModeList;
    }

}
