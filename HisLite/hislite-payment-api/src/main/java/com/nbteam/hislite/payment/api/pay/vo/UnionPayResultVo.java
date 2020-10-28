package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 统一下单支付返回
 *
 */
public class UnionPayResultVo extends BaseResultVo {
    private static final long serialVersionUID = 1L;

    // 医院订单号
    private String hisOrdNum;
    // 平台订单号
    private String psOrdNum;
    // 支付id
    private String prepayId;

    public String getHisOrdNum() {
        return hisOrdNum;
    }

    public void setHisOrdNum(String hisOrdNum) {
        this.hisOrdNum = hisOrdNum;
    }

    public String getPsOrdNum() {
        return psOrdNum;
    }

    public void setPsOrdNum(String psOrdNum) {
        this.psOrdNum = psOrdNum;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

}