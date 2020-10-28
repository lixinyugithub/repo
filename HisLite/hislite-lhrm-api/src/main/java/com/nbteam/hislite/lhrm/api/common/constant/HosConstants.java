package com.nbteam.hislite.lhrm.api.common.constant;


/**  
* 类名称：Globals   
* 类描述：  全局变量定义
* @version
 */
public interface HosConstants {
	String  DATA_DIC_CACHE="hislite-hospital-ems-dataDic";//字典缓存

    /** 交易成功(下单成功) */
    public static final String RETURN_CODE_SUCCESS = "0";
    /** 交易失败(下单失败) */
    public static final String RETURN_CODE_FAIL = "1";
    /** 交易未知(下单未知) */
    public static final String RETURN_CODE_UNKNOW = "2";
    
    /** 交易成功(下单成功) */
    public static final String SUCCESS_CODE = "SUCCESS";
    /** 交易成功(下单成功) */
    public static final String HIS_SUCCESS_CODE = "0";
    /** 交易失败(下单失败) */
    public static final String HIS_FAIL_CODE = "1";

    /** 1:待支付; 2:已支付未通知 HIS; 3:退费中; 4:已退款; 5:支付失败; 6:支付中; 7:支付成功通知HIS失败; 9:支付成功通知HIS成功
        10:支付失败，11:订单关闭 */
    public static final String PAY_ORDER_STATUS_PAYED = "7";
    public static final String PAY_ORDER_STATUS_HIS_PAYED = "9";


}
