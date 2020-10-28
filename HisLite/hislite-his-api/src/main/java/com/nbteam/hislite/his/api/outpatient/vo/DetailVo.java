package com.nbteam.hislite.his.api.outpatient.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Description: 定义的支付商品详情<br/>
 *
 * @author liujingcheng
 * @date: 2016年10月27日 下午8:52:46
 * @version 1.0
 * @since JDK 1.7
 */
public class DetailVo implements Serializable {

    /** 
     */
    private static final long serialVersionUID = 7811499914888094405L;
    /**
     * 商品详情
     */
    private List<WxPayFormItemVo> goodsDetail;

    public List<WxPayFormItemVo> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<WxPayFormItemVo> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

}
