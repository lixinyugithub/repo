package com.nbteam.hislite.common.constant;


import java.util.HashMap;
import java.util.Map;

/**
* 类名称：Globals   
* 类描述：  全局变量定义
* @version
 */
public class CommonConstants {

	public static final String CHARSET_UTF8 ="utf-8";
	/**
	* 认证tocken 定义
	*/
	public static final String   ACCESS_TOCKEN = "accessToken";
	/****缓存地址begin***********/
	public static final String   CACH_SYS_USER = "hislite-hos-manager-user"; // 缓存系统用户
	//过期时间，与session过期时间保持一致
	public static final int  MAX_INACTIVEIN_TERVALIN_SECONDS = 1800;
	//rdis token
	public static final String TOKEN_REDIS_NAME = "spring:session:accessToken:";
	//当客户端没有传xxx参数的时候，避免创建多个无用的session占用redis空间  设置默认
	public static final String DEFAULT_SESSIONID = "97507ace";

	public static final String SESSION_USER = "sessionUser";
	/********end*************/

	/**
	 * 否
	 */
	public static final Integer NO = 0;
	/**
	 * 是
	 */
	public static final Integer YES = 1;

	/** 支付锁key */
	public static final String GENERATOR_PAYMENT_SYNC_KEY = "generator_payorder_";

	/** 通知锁 */
	public static final String GENERATOR_HIS_SYNC_KEY = "oppayOrder_send_lock_";

	/** 平台来源 1-微信 2-支付宝 8-睿博支付 */
	public static final Integer PLATFORM_SOURCE_WEIXIN = 1;
	public static final Integer PLATFORM_SOURCE_ALIPAY = 2;
	public static final Integer PLATFORM_SOURCE_WITONPAY = 8;

	/** 支付方式 1-微信 2-支付宝 8-睿博支付 */
	public static final String PAY_TYPE_WEIXIN = "1";
	public static final String PAY_TYPE_ALIPAY = "2";
	public static final String PAY_TYPE_WITON = "8";
	public static final Map<String, String> PAY_TYPE_MAP = new HashMap<>();
	static {
		PAY_TYPE_MAP.put(PAY_TYPE_WEIXIN, "weixin");
		PAY_TYPE_MAP.put(PAY_TYPE_ALIPAY, "alipay");
		PAY_TYPE_MAP.put(PAY_TYPE_WITON, "witon");
	}
}
