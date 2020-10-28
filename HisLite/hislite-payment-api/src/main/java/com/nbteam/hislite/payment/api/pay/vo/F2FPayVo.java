package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

import java.util.Date;

/**
 * 
 * 当面付返回
 *
 */
public class F2FPayVo extends BaseResultVo {
    /** 
     */
    private static final long serialVersionUID = -4799311158196674429L;

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
    private Date payTime;

    /**
     * 渠道唯一ID
     */
    private String unionId;

    /**
     * 买家账号
     */
    private String buyerAlipayAccount;

    /** 交易类型 */
    private String tradeType;
    /** 银行 */
    private String bankType;
    /** 货币类型 */
    private String feeType;

    /** {@linkplain #tradeType} */
    public String getTradeType() {
        return tradeType;
    }

    /** {@linkplain #tradeType} */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    /** {@linkplain #bankType} */
    public String getBankType() {
        return bankType;
    }

    /** {@linkplain #bankType} */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /** {@linkplain #feeType} */
    public String getFeeType() {
        return feeType;
    }

    /** {@linkplain #feeType} */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getBuyerAlipayAccount() {
        return buyerAlipayAccount;
    }

    public void setBuyerAlipayAccount(String buyerAlipayAccount) {
        this.buyerAlipayAccount = buyerAlipayAccount;
    }

}
