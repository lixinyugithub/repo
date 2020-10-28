package com.nbteam.hislite.payment.api.common.constant;


/**  
* 类名称：PayConstants
* 类描述：  全局变量定义
* @version
 */
public interface PaymentConstants {

    /********************** 公用配置常量 ***********************************/
    public static final Integer NO = 0;
    public static final Integer YES = 1;
    /** 支付中心redis key前缀 */
    public static final String PAY_CENTER_REDIS_PREFIX = "pay_cache_";
    /** 支付中心redis默认超时时间 秒 */
    public static final Integer PAY_CENTER_REDIS_DEFAULT_TIMEOUT = 60;
    /** 数据缓存时间默认48小时 */
    public static final Integer PAY_CENRER_REDIS_BIZ_TIMEOUT = 48 * 60 * 60;
    /** 订单锁key */
    public static final String GENERATOR_ORDER_SYNC_KEY = "generator_payorder_";
    /** 未知状态 */
    public static final String RESULT_UNKNOW_CODE = "UNKNOW";
    /** 字符集编码 */
    public static final String DEFAULT_CHARSET = "utf-8";
    /** 默认支付默认有效时间 */
    public static final Integer PAY_EFFECTIVE_TIME = 310;

    /********************* 支付宝常量配置 **********************************/
    /** 支付宝网关地址 */
    public static final String APLIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";
    /** 报文格式 */
    public static final String APLIPAY_DEFAULT_FROMAT = "json";
    /** 接口版本 */
    public static final String APLIPAY_INTERFACEVERSION = "1.0";
    /** 加密类型V1 */
    public static final String APLIPAY_SIGNTYPEV1 = "RSA";
    /** 加密类型V2 */
    public static final String APLIPAY_SIGNTYPEV2 = "RSA2";
    /** 微信支付超时时间 15分钟 */
    public static final String ALIPAY_DEFAULT_TIMEOUT = "15m";

    /***************************** 微信常量配置 *********************************************/
    /** 支付成功(下单成功) */
    public static final String RETURN_CODE_SUCCESS = "0";
    /** 支付失败(下单失败) */
    public static final String RETURN_CODE_FAIL = "1";
    public static final String RESULT_SUCCESS_CODE = "0";
    public static final String RESULT_FAIL_CODE = "1";
    public static final String RESULT_ERROR_MESSAGE = "系统异常,请联络管理员";
    /** 微信挂号类型 */
    public static final String WEIXIN_REGISTER_TYPE = "RegPay";
    /** 微信门诊类型 */
    public static final String WEIXIN_OPPAY_TYPE = "DiagPay";

    /** INIT("U", "预登记"), SUCCESS("S", "成功"), UNKNOW("I", "未知"), FAILURE("F", "失败"), REVOKE("O", "已撤销"), REFUND("R", "已退款")
            , CANCELED("C", "关闭") */
    public static final String PAY_STATUS_INIT = "U";
    public static final String PAY_STATUS_SUCCESS = "S";
    public static final String PAY_STATUS_UNKNOW = "I";
    public static final String PAY_STATUS_FAILURE = "F";
    public static final String PAY_STATUS_REVOKE = "O";
    public static final String PAY_STATUS_CANCELED = "C";
    public static final String PAY_STATUS_REFUND = "R";

    /** 支付方法(wap-wap支付，app-app支付，qr-扫码付，f2f-扫码付，medicareOnline-在线医保支付，prepaidCard-预付卡支付，zero-零元支付，credit-信用卡支付，withhod-代扣支付) */
    public static final String PAY_METHOD_WAP = "wap";
    public static final String PAY_METHOD_QR = "qr";
    public static final String PAY_METHOD_APP = "app";


    public static final String PAY_CHANNEL_ALIPAY = "alipay";
    public static final String PAY_CHANNEL_WEIXIN = "weixin";

    /** INIT("U", "预登记"), SUCCESS("S", "成功"), UNKNOW("I", "未知"), FAILURE("F", "失败"), REVOKE("O", "已撤销"), CANCELED("C",
     "超时关闭"), REFUND("R", "退款") */
    public static final String SERIL_STATUS_INIT = "U";
    public static final String SERIL_STATUS_SUCCESS = "S";
    public static final String SERIL_STATUS_UNKNOW = "I";
    public static final String SERIL_STATUS_FAILURE = "F";
    public static final String SERIL_STATUS_REVOKE = "O";
    public static final String SERIL_STATUS_CANCELED = "C";
    public static final String SERIL_STATUS_REFUND = "R";

    /** 支付中心的消息类型: PAYED_RESULT_NOTICE-支付结果通知 REFUND_STATUS_CHANGE-退款单状态更改通知 */
    public static final String PAY_MSG_TYPE_PAYED = "P";
    public static final String PAY_MSG_TYPE_REFUND = "F";

    /** 支付宝返回码 10000-SUCCESS 20000-UNKNOW 20001-INVALID_TOKEN 40001-MISSON_METHOD 40002-INVALID_METHOD
     * 40004-BUSINESS_ERROR 40006-PERMISSION_ERROR */
    public static final String ALIPAY_RESULT_SUCCESS = "10000";
    public static final String ALIPAY_RESULT_UNKNOW = "20000";
    public static final String ALIPAY_RESULT_INVALID_TOKEN = "20001";
    public static final String ALIPAY_RESULT_MISSON_METHOD = "40001";
    public static final String ALIPAY_RESULT_INVALID_METHOD = "40002";
    public static final String ALIPAY_RESULT_BUSINESS_ERROR = "40004";
    public static final String ALIPAY_RESULT_PERMISSION_ERROR = "40006";

    /** 支付宝订单状态 TRADE_SUCCESS-SUCCESS WAIT_BUYER_PAY-UNKNOW TRADE_FINISHED-FINISHED TRADE_CLOSED-CLOSED */
    public static final String ALIPAY_TRADE_SUCCESS = "TRADE_SUCCESS";
    public static final String ALIPAY_TRADE_NKNOW = "WAIT_BUYER_PAY";
    public static final String ALIPAY_TRADE_FINISHED = "TRADE_FINISHED";
    public static final String ALIPAY_TRADE_CLOSED = "TRADE_CLOSED";

}
