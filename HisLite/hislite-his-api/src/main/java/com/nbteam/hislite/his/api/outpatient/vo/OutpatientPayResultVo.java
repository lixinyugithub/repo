package com.nbteam.hislite.his.api.outpatient.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 
 * 门诊缴费支付返回结果
 *
 */
@XmlRootElement(name = "response")
public class OutpatientPayResultVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 结果
     */
    @ApiModelProperty("结果 success/error")
    private String result;

    /**
     * 错误描述
     */
    @ApiModelProperty("错误描述")
    private String message;

    /**
     * 发票号
     */
    @ApiModelProperty("发票号")
    private String invoiceNo;

    /**
     * His 支付流水号
     */
    @ApiModelProperty("His 支付流水号")
    private String serialNo;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
