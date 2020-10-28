package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Description: 待付款订单详情<br/>
 *
 */
public class WaitPayOrderItemVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = 7857538975182358807L;
    /** itemId **/
    private String itemId;
    /** 项目名称 */
    private String name;
    /** 类别id */
    private String caregoryId;
    /** 项目类别 */
    private String category;
    /** 项目规格 */
    private String spec;
    /** 单位 */
    private String unit;
    /** 单价 */
    private String price;
    /** 数量 */
    private String num;
    /** 总金额 */
    private String totalFee;
    /** 执行科室/部门 */
    private String deptName;
    /** 执行地址 */
    private String address;
    /**二级项目列表*/
    private List<WaitPayOrderItemVo> subItemList;

    /** 返回 itemId */
    public String getItemId() {
        return itemId;
    }

    /** 设置 itemId */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /** 返回 执行科室部门 */
    public String getDeptName() {
        return deptName;
    }

    /** 设置 执行科室部门 */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 返回 执行地址 */
    public String getAddress() {
        return address;
    }

    /** 设置 执行地址 */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public List<WaitPayOrderItemVo> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<WaitPayOrderItemVo> subItemList) {
        this.subItemList = subItemList;
    }

    public String getCaregoryId() {
        return caregoryId;
    }

    public void setCaregoryId(String caregoryId) {
        this.caregoryId = caregoryId;
    }
}
