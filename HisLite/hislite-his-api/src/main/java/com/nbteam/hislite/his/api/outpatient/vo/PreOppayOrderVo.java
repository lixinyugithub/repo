package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Description: 缴费订单创建订单前对象<br/>
 *
 */
public class PreOppayOrderVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = -6143301485834655005L;
    /** 用户id */
    private Long userId;
    /** 平台id */
    private Long platformId;
    /** 医院id */
    private Long hisId;
    /** 医院名称 */
    private String hisName;
    /** 待支付列表 */
    private List<WaitPayOrderVo> waitOrders;
    /** 医院待支付订单信息 */
    private WaitPayOrderVo payOrder;
    /**
     * 渠道来源（1-微信 2-支付宝 3-app)
     */
    private Integer platformSource;
    /** 设备id */
    private String devId;

    /** 返回 平台id */
    public Long getPlatformId() {
        return platformId;
    }

    /** 设置 平台id */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public List<WaitPayOrderVo> getWaitOrders() {
        return waitOrders;
    }

    public void setWaitOrders(List<WaitPayOrderVo> waitOrders) {
        this.waitOrders = waitOrders;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public WaitPayOrderVo getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(WaitPayOrderVo payOrder) {
        this.payOrder = payOrder;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

}
