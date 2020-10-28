package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;

/**
 * 
 * Description: 微信支付formitem<br/>
 *
 * @author liujingcheng
 * @date: 2016年10月25日 下午8:23:51
 * @version 1.0
 * @since JDK 1.7
 */
public class WxPayFormItemVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = -1494162293576313779L;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 微信商品id
     */
    private String wxPayGoodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 数量
     */
    private String quantity;
    /**
     * 价格
     */
    private String price;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getWxPayGoodsId() {
        return wxPayGoodsId;
    }

    public void setWxPayGoodsId(String wxPayGoodsId) {
        this.wxPayGoodsId = wxPayGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
