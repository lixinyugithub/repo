package com.nbteam.hislite.his.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 门诊缴费支付参数<br/>
 *
 */

@XmlRootElement(name = "OutpatientPayParamVo")
public class OutpatientPayParamVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用单编号,多个处方用,分隔
     */
    @ApiModelProperty("费用单编号")
    private String prescriptionNo;

    /**
     * 就诊人姓名-校验唯一性
     */
    @ApiModelProperty("就诊人姓名")
    private String realName;

    /**
     * 就诊人卡号
     */
    @ApiModelProperty("就诊人卡号")
    private String patientCard;

    /**
     * 缴费金额
     */
    @ApiModelProperty("缴费金额")
    private String orderFee;

    /**
     * 费用类型
     */
    @ApiModelProperty("费用类型")
    private String feeType;

    /**
     * 付款来源 -weChat/aliPay/eCardPay
     */
    @ApiModelProperty("付款来源")
    private String payType;

    /**
     * 缴费成功时间
     */
    @ApiModelProperty("缴费成功时间")
    private String updateDate;

    /**
     * 商户交易订单号
     */
    @ApiModelProperty("商户交易订单号")
    private String tradeNo;

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(String patientCard) {
        this.patientCard = patientCard;
    }

    public String getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(String orderFee) {
        this.orderFee = orderFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}