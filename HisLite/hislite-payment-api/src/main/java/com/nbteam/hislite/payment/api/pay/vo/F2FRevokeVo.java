package com.nbteam.hislite.payment.api.pay.vo;

import com.nbteam.hislite.common.vo.BaseResultVo;

/**
 * 
 * 取消订单返回
 *
 */
public class F2FRevokeVo extends BaseResultVo {
    /** 
     */
    private static final long serialVersionUID = -7916904865964829347L;

    /**
     * 撤销状态 -1：撤销失败 0：撤销成功
     */
    private String revokeStatus;

    /**
     * 撤销状态说明
     */
    private String revokeStatusDes;

    public String getRevokeStatus() {
        return revokeStatus;
    }

    public void setRevokeStatus(String revokeStatus) {
        this.revokeStatus = revokeStatus;
    }

    public String getRevokeStatusDes() {
        return revokeStatusDes;
    }

    public void setRevokeStatusDes(String revokeStatusDes) {
        this.revokeStatusDes = revokeStatusDes;
    }

}
