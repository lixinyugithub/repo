package com.nbteam.hislite.payment.api.exception;

import com.nbteam.hislite.common.exception.BusinessException;

/**
 * 
 * 支付中心异常信息（用户中心code范围为 1004xxxx）<br/>
 *
 */
public class PaymentException extends BusinessException {

    /** 
     */
    private static final long serialVersionUID = 1L;
    /** 支付中心网关异常code */
    public static final Integer PAYCENTER_GATEWAY_ERROR = 10099999;
    /** 支付中心返回数据异常 */
    public static final Integer PAYCENTER_BUSINESS_ERROR = 10088888;
    /** 医保服务异常code */
    public static final Integer MED_BIZ_ERROR = 10080000;

    /**
     * 系统异常
     */
    public static final Integer SYSTEM_ERROR_CODE = 10040000;
    /**
     * 根据业务订单号找不到对应的支付成功的支付订单
     */
    public static final Integer INCOMEORDER_NOT_FOUND_ERROR_CODE = 10040001;
    /**
     * 剩余可退款金额不足
     */
    public static final Integer LEFT_FEE_NOT_ENOUGH_ERROR_CODE = 10040002;
    /**
     * 根据支付订单找不到对应的商户配置信息
     */
    public static final Integer MERCHANT_NOT_FOUND_ERROR_CODE = 10040003;
    /**
     * 支付订单找不到错误
     */
    public static final Integer PAYORDER_NULL_ERROR_CODE = 10040004;
    /**
     * 解析返回的数据错误
     */
    public static final Integer READ_WX_MSG_ERROR_CODE = 10040005;
    /**
     * 业务订单号为空
     */
    public static final Integer ORDERID_NULL_ERROR_CODE = 10040006;
    /**
     * 退款金额不合法
     */
    public static final Integer REFUND_FEE_ILLEGAL_ERROR_CODE = 10040007;

    /**
     * 不合法的商户
     */
    public static final Integer INVALIDATE_MERCHANT_INFO_CODE = 10040008;
    /**
     * 微信接口错误
     */
    /* SYSTEMERROR 接口返回错误 系统超时 请用相同参数再次调用API */
    public static final Integer WX_SYSTEMERROR_ERROR_CODE = 10040101;
    /* USER_ACCOUNT_ABNORMAL 退款请求失败 用户帐号注销 此状态代表退款申请失败，商户可自行处理退款。 */
    public static final Integer WX_USER_ACCOUNT_ABNORMAL_ERROR_CODE = 10040102;
    /* NOTENOUGH 余额不足 商户可用退款余额不足 此状态代表退款申请失败，商户可根据具体的错误提示做相应的处理。 */
    public static final Integer WX_NOTENOUGH_ERROR_CODE = 10040006;
    /*
     * INVALID_TRANSACTIONID 无效transaction_id 请求参数未按指引进行填写
     * 请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败
     */
    public static final Integer WX_INVALID_TRANSACTIONID_ERROR_CODE = 10040103;
    /* PARAM_ERROR 参数错误 请求参数未按指引进行填写 请求参数错误，请重新检查再调用退款申请 */
    public static final Integer WX_PARAM_ERROR_ERROR_CODE = 10040104;
    /* APPID_NOT_EXIST APPID不存在 参数中缺少APPID 请检查APPID是否正确 */
    public static final Integer WX_APPID_NOT_EXIST_ERROR_CODE = 10040105;
    /* MCHID_NOT_EXIST MCHID不存在 参数中缺少MCHID 请检查MCHID是否正确 */
    public static final Integer WX_MCHID_NOT_EXIST_ERROR_CODE = 10040106;
    /*
     * APPID_MCHID_NOT_MATCH appid和mch_id不匹配 appid和mch_id不匹配 请确认appid和mch_id是否匹配
     */
    public static final Integer WX_APPID_MCHID_NOT_MATCH_ERROR_CODE = 10040107;
    /* REQUIRE_POST_METHOD 请使用post方法 未使用post传递参数 请检查请求参数是否通过post方法提交 */
    public static final Integer WX_REQUIRE_POST_METHOD_ERROR_CODE = 10040108;
    /* SIGNERROR 签名错误 参数签名结果不正确 请检查签名参数和方法是否都符合签名算法要求 */
    public static final Integer WX_SIGNERROR_ERROR_CODE = 10040109;
    /* XML_FORMAT_ERROR XML格式错误 XML格式错误 请检查XML参数格式是否正确 */
    public static final Integer WX_XML_FORMAT_ERROR_ERROR_CODE = 10040110;

    public PaymentException() {
    }

    public PaymentException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    @Override
    public String toString() {
        return "PayCenterException [msg=" + msg + ", code=" + code + "]";
    }

}
