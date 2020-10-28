package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 支付订单查询返回
 *
 */
public class PayQueryVo extends BaseResultVo {
    /** 
     */
    private static final long serialVersionUID = -4597216443473066075L;

    /**
     * 支付金额
     */
    private Integer totalFee;

    /**
     * 交易流水号
     */
    private String acquireSerialNo;

    /**
     * openId
     */
    private String openId;

    /**
     * 支付时间
     */
    private Date payedTime;

    /**
     * 渠道唯一ID
     */
    private String unionId;

    /**
     * 买家支付宝账号
     */
    private String buyerAlipayAccount;

    /** 付款银行 */
    private String bankType;
    /** 商户支付号 */
    private String merchantOrderId;

    /** {@linkplain #totalFee} */
    public Integer getTotalFee() {
        return totalFee;
    }

    /** {@linkplain #totalFee} */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /** {@linkplain #acquireSerialNo} */
    public String getAcquireSerialNo() {
        return acquireSerialNo;
    }

    /** {@linkplain #acquireSerialNo} */
    public void setAcquireSerialNo(String acquireSerialNo) {
        this.acquireSerialNo = acquireSerialNo;
    }

    /** {@linkplain #openId} */
    public String getOpenId() {
        return openId;
    }

    /** {@linkplain #openId} */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /** {@linkplain #payedTime} */
    public Date getPayedTime() {
        return payedTime;
    }

    /** {@linkplain #payedTime} */
    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    /** {@linkplain #unionId} */
    public String getUnionId() {
        return unionId;
    }

    /** {@linkplain #unionId} */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /** {@linkplain #buyerAlipayAccount} */
    public String getBuyerAlipayAccount() {
        return buyerAlipayAccount;
    }

    /** {@linkplain #buyerAlipayAccount} */
    public void setBuyerAlipayAccount(String buyerAlipayAccount) {
        this.buyerAlipayAccount = buyerAlipayAccount;
    }

    /** {@linkplain #bankType} */
    public String getBankType() {
        return bankType;
    }

    /** {@linkplain #bankType} */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /** {@linkplain #merchantOrderId} */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /** {@linkplain #merchantOrderId} */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

}
