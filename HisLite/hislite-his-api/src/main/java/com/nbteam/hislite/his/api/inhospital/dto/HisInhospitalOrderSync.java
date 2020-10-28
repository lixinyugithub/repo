package com.nbteam.hislite.his.api.inhospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class HisInhospitalOrderSync implements Serializable {
    @ApiModelProperty("主键id")
    private Long inhospitalOrderSyncId;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("对象id（订单，退款单）")
    private Long objectId;

    @ApiModelProperty("同步系统或模块名称（支付pay，等等）")
    private String systemName;

    @ApiModelProperty("发送类型")
    private String type;

    @ApiModelProperty("业务类型")
    private String bizType;

    @ApiModelProperty("状态，是否成功（0-否 1-是）")
    private Integer status;

    @ApiModelProperty("发送次数")
    private Integer times;

    @ApiModelProperty("发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    @ApiModelProperty("备注")
    private String memo;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getInhospitalOrderSyncId() {
        return inhospitalOrderSyncId;
    }

    public void setInhospitalOrderSyncId(Long inhospitalOrderSyncId) {
        this.inhospitalOrderSyncId = inhospitalOrderSyncId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}