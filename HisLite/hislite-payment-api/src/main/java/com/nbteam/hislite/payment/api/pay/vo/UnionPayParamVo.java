package com.nbteam.hislite.payment.api.pay.vo;

/**
 * 
 * 统一下单入参
 *
 */
public class UnionPayParamVo extends BaseParamVo {
    private static final long serialVersionUID = 2777583691030795899L;

    /**
     * 业务类型 必填
     */
    private String bizType;

    /**
     * 微信公众账号id 必填
     */
    private String appId;

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB" 网页支付或者公众号支付可为空
     */
    private String deviceInfo;
    /**
     * 商品描述 交易字段格式根据不同的应用场景按照以下格式：
     * （1）PC网站——传入浏览器打开的网站主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值； （2）
     * 公众号——传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔； （3）
     * H5——应用在浏览器网页上的场景，传入浏览器打开的移动网页的主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值； （4）
     * 线下门店——门店品牌名-城市分店名-实际商品名称，例如： image形象店-深圳腾大- QQ公仔） （5）
     * APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。 必填
     */
    private String body;
    /**
     * 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。 goods_detail 服务商必填 []： └
     * goods_id String 必填 32 商品的编号 └ wxpay_goods_id String 可选 32 微信支付定义的统一商品编号 └
     * goods_name String 必填 256 商品名称 └ quantity Int 必填 商品数量 └ price Int 必填
     * 商品单价，单位为分 └ goods_category String 可选 32 商品类目ID └ body String 可选 1000
     * 商品描述信息 实例: { "goods_detail":[ { "goods_id":"iphone6s_16G",
     * "wxpay_goods_id":"1001", "goods_name":"iPhone6s 16G", "quantity":1,
     * "price":528800, "goods_category":"123456", "body":"苹果手机" }, {
     * "goods_id":"iphone6s_32G", "wxpay_goods_id":"1002", "goods_name":
     * "iPhone6s 32G", "quantity":1, "price":608800, "goods_category":"123789",
     * "body":"苹果手机" } ] } 选填
     */
    private String detail;
    /**
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 选填
     */
    private String attach;
    /**
     * 业务订单号 必填
     */
    private Long bizOrderId;
    /**
     * 医院订单号 必填
     */
    private String hisOrderNo;
    /**
     * 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY 选填
     */
    private String feeType;
    /**
     * 订单总金额，只能为整数，单位是分 必填
     */
    private Integer totalFee;
    /**
     * 终端ip APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。 必填
     */
    private String spbillCreateIp;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010 选填
     */
    private String timeStart;
    /**
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010 选填
     */
    private String timeExpire;
    /**
     * 商品标记，代金券或立减优惠功能的参数 选填
     */
    private String goodsTag;
    /**
     * 交易类型 取值如下：JSAPI，NATIVE，APP 必填
     */
    private String tradeType;
    /**
     * 商品id trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    private String productId;
    /**
     * 指定支付方式 no_credit--指定不能使用信用卡支付 选填
     */
    private String limitPay;
    /**
     * 用户标识 trade_type=JSAPI，此参数必传，用户在主商户appid下的唯一标识。openid和sub_openid可以选传其中之一，
     * 如果选择传sub_openid,则必须传sub_appid。
     */
    private String openId;
    /**
     * 用户子标识 trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，
     * 如果选择传sub_openid,则必须传sub_appid
     */
    private String subOpenId;

    /**
     * 内部用户id
     */
    private Long userId;

    /**
     * 渠道来源 必填
     */
    private String platformSource;

    /**
     * {@linkplain #userId}
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * {@linkplain #userId}
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * {@linkplain #bizType}
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * {@linkplain #bizType}
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * {@linkplain #appId}
     */
    public String getAppId() {
        return appId;
    }

    /**
     * {@linkplain #appId}
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * {@linkplain #deviceInfo}
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * {@linkplain #deviceInfo}
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * {@linkplain #body}
     */
    public String getBody() {
        return body;
    }

    /**
     * {@linkplain #body}
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * {@linkplain #detail}
     */
    public String getDetail() {
        return detail;
    }

    /**
     * {@linkplain #detail}
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * {@linkplain #attach}
     */
    public String getAttach() {
        return attach;
    }

    /**
     * {@linkplain #attach}
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * {@linkplain #feeType}
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * {@linkplain #feeType}
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /**
     * {@linkplain #totalFee}
     */
    public Integer getTotalFee() {
        return totalFee;
    }

    /**
     * {@linkplain #totalFee}
     */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * {@linkplain}
     */
    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    /**
     * {@linkplain}
     */
    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    /**
     * {@linkplain #timeStart}
     */
    public String getTimeStart() {
        return timeStart;
    }

    /**
     * {@linkplain #timeStart}
     */
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * {@linkplain #timeExpire}
     */
    public String getTimeExpire() {
        return timeExpire;
    }

    /**
     * {@linkplain #timeExpire}
     */
    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    /**
     * {@linkplain #goodsTag}
     */
    public String getGoodsTag() {
        return goodsTag;
    }

    /**
     * {@linkplain #goodsTag}
     */
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    /**
     * {@linkplain #limitPay}
     */
    public String getLimitPay() {
        return limitPay;
    }

    /**
     * {@linkplain #limitPay}
     */
    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    /**
     * {@linkplain #hisId}
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * {@linkplain #openId}
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * {@linkplain #subOpenId}
     */
    public String getSubOpenId() {
        return subOpenId;
    }

    /**
     * {@linkplain #subOpenId}
     */
    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    /**
     * {@linkplain #tradeType}
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * {@linkplain #tradeType}
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * {@linkplain #productId}
     */
    public String getProductId() {
        return productId;
    }

    /**
     * {@linkplain #productId}
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * {@linkplain #bizOrderId}
     */
    public Long getBizOrderId() {
        return bizOrderId;
    }

    /**
     * {@linkplain #bizOrderId}
     */
    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    /**
     * {@linkplain #hisOrderNo}
     */
    public String getHisOrderNo() {
        return hisOrderNo;
    }

    /**
     * {@linkplain #hisOrderNo}
     */
    public void setHisOrderNo(String hisOrderNo) {
        this.hisOrderNo = hisOrderNo;
    }

    public String getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(String platformSource) {
        this.platformSource = platformSource;
    }
}