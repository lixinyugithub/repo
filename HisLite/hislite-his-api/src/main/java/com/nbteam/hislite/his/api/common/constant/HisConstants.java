package com.nbteam.hislite.his.api.common.constant;


/**  
* 类名称：Globals   
* 类描述：  全局变量定义
* @version
 */
public interface HisConstants {

    /** outpatient-门诊缴费 inpatient-住院缴费 */
    public static final String BIZ_TYPE_OUTPATIENT = "outpatient";
    public static final String BIZ_TYPE_INPATIENT = "inpatient";

    /** 支付状态 */
    public static final Integer PAY_STATUS_PAYED = 1;
    public static final Integer PAY_STATUS_NOT_PAY = 0;

    /** 同步状态 */
    public static final Integer ORDER_SYNC_FAILURE = 0;
    public static final Integer ORDER_SYNC_SUCCESS = 1;
    public static final Integer ORDER_SYNC_EXCEPTION = 2;

    /** 门诊支付订单状态 init("U", "初始预登记"), payed("P", "付款完成，调用医院支付接口中"), his_payed("S", "付款完成，医院确认成功"), pay_failure("F", "缴费失败"), paying("H",
     "付款完成，医院确认超时或出现故障"),REMOTE_ERROR_TIMES("Z", "调用医院接口异常，重发次数超限"), canceled("C", "已取消") */
    public static final String OPPAY_STATUS_INIT = "U";
    public static final String OPPAY_STATUS_PAYED = "P";
    public static final String OPPAY_STATUS_HIS_PAYED = "S";
    public static final String OPPAY_STATUS_FAILURE = "F";
    public static final String OPPAY_STATUS_PAYING = "H";
    public static final String OPPAY_STATUS_REMOTE_ERROR_TIMES = "Z";


    /** 外部系统返回的成功标志 */
    public static final String EXTENDS_RETURN_SUCCSS_CODE = "0";
    public static final String EXTENDS_RETURN_FAILURE_CODE = "1";
    public static final String EXTENDS_RETURN_EXCEPTION_CODE = "2";

    /**
     * 支付通知医院明确告诉成功
     */
    public static final String REMOTE_HIS_SUCCESS_CODE = "0";
    /**
     * 支付通知医院明确告诉失败
     */
    public static final String REMOTE_HIS_FAILURE_CODE = "1";

    /**
     * 支付通知医院未明确，原因未知
     */
    public static final String REMOTE_HIS_EXCEPTION_CODE = "2";

    /**
     * 已支付
     */
    public static final String SEND_TYPE_PAYED = "payed";


    /** 住院支付订单状态 init("U", "初始预登记"), payed("P", "付款完成，调用医院支付接口中"), his_payed("S", "付款完成，医院确认成功"), pay_failure("F", "缴费失败"), his_exception("H",
     "付款完成，医院确认超时或出现故障"),his_exception_end("Z", "调用医院接口异常，重发次数超限"), canceled("C", "已取消") */
    public static final String INHOSPITAL_ORDER_STATUS_INIT = "U";
    public static final String INHOSPITAL_ORDER_STATUS_PAYED = "P";
    public static final String INHOSPITAL_ORDER_STATUS_HIS_PAYED = "S";
    public static final String INHOSPITAL_ORDER_STATUS_FAILURE = "F";
    public static final String INHOSPITAL_ORDER_STATUS_HIS_EXCEPTION = "H";
    public static final String INHOSPITAL_ORDER_STATUS_HIS_EXCEPTION_END = "Z";


    /** INIT(0, "初始状态"), REFUNDINGS(1, "退款中"), SUCCESS(2, "退款成功"), FAILURE(3, "退款失败"); */
    public static final Integer INHOSPITAL_ORDER_REFUND_STATUS_INIT = 0;
    public static final Integer INHOSPITAL_ORDER_REFUND_STATUS_REFUNDINGS = 1;
    public static final Integer INHOSPITAL_ORDER_REFUND_STATUS_SUCCESS = 2;
    public static final Integer INHOSPITAL_ORDER_REFUND_STATUS_FAILURE = 3;

}
