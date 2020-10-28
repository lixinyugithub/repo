package com.nbteam.hislite.his.api.his.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class HospitalHis implements Serializable {
    private Long id;

    @ApiModelProperty("别名")
    private String alias;

    @ApiModelProperty("医院名称")
    private String name;

    @ApiModelProperty("医院所属省份代码")
    private String provinceNo;

    @ApiModelProperty("医院所属城市代码")
    private String cityNo;

    @ApiModelProperty("医院所在区域代码")
    private String areaNo;

    @ApiModelProperty("0:非最底层（说明它有子院）1：最底层（说明它没有子院，默认值）")
    private Integer type;

    @ApiModelProperty("0：无上级医院")
    private String parentHisNo;

    @ApiModelProperty("医院详细地址")
    private String address;

    @ApiModelProperty("医院电话")
    private String telNo;

    private String website;

    @ApiModelProperty("医院等级： 11：一级甲等医院12：一级乙等医院13：一级丙等医院21：二级甲等医院22：二级乙等医院23：二级丙等医院31：三级甲等医院32：三级乙等医院33：三级丙等医院")
    private Integer level;

    @ApiModelProperty("医院等级名称")
    private String levelName;

    @ApiModelProperty("医院联系人")
    private String contacts;

    @ApiModelProperty("医院联系人")
    private String contactsPhoneNo;

    @ApiModelProperty("联系人邮箱")
    private String contactsEmail;

    @ApiModelProperty("医院图片路径")
    private String imgPath;

    @ApiModelProperty("医院楼层分布图")
    private String floorImgPath;

    @ApiModelProperty("来院交通图地址")
    private String trafficImgPath;

    @ApiModelProperty("门诊预约电话")
    private String regTel;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("维度")
    private String latitude;

    @ApiModelProperty("医院logo地址")
    private String logoUrl;

    @ApiModelProperty("拼音首字母")
    private String pyInitials;

    @ApiModelProperty("标签")
    private String tag;

    @ApiModelProperty("预约挂号天数")
    private Integer regsterLimitDays;

    @ApiModelProperty("号源过期时间：秒")
    private Integer regsterTimeOut;

    @ApiModelProperty("排序")
    private Integer rank;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("扩展字段,json格式")
    private String extFields;

    @ApiModelProperty("医院简介")
    private String introduction;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentHisNo() {
        return parentHisNo;
    }

    public void setParentHisNo(String parentHisNo) {
        this.parentHisNo = parentHisNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsPhoneNo() {
        return contactsPhoneNo;
    }

    public void setContactsPhoneNo(String contactsPhoneNo) {
        this.contactsPhoneNo = contactsPhoneNo;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getFloorImgPath() {
        return floorImgPath;
    }

    public void setFloorImgPath(String floorImgPath) {
        this.floorImgPath = floorImgPath;
    }

    public String getTrafficImgPath() {
        return trafficImgPath;
    }

    public void setTrafficImgPath(String trafficImgPath) {
        this.trafficImgPath = trafficImgPath;
    }

    public String getRegTel() {
        return regTel;
    }

    public void setRegTel(String regTel) {
        this.regTel = regTel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getPyInitials() {
        return pyInitials;
    }

    public void setPyInitials(String pyInitials) {
        this.pyInitials = pyInitials;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getRegsterLimitDays() {
        return regsterLimitDays;
    }

    public void setRegsterLimitDays(Integer regsterLimitDays) {
        this.regsterLimitDays = regsterLimitDays;
    }

    public Integer getRegsterTimeOut() {
        return regsterTimeOut;
    }

    public void setRegsterTimeOut(Integer regsterTimeOut) {
        this.regsterTimeOut = regsterTimeOut;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}