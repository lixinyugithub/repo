package com.nbteam.hislite.common.exception;

/**
 * @ClassName: BusinessException
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2018-08-16 9:30
 */
public class BusinessException extends BizException {
    /**
     */
    private static final long serialVersionUID = 1L;

    /** 查询异常code */
    public static final Integer QUERY_ERROR_CODE = 10101001;
    /** 插入异常code */
    public static final Integer INSERT_ERROR_CODE = 10101002;
    /** 跟心异常code */
    public static final Integer UPDATE_ERROR_CODE = 10101003;
    /** 业务异常code */
    public static final Integer BUSINESS_ERROR_CODE = 10101004;
    /** 参数为空异常code */
    public static final Integer PARAMS_NULL_ERROR = 10101005;
    /** 参数不合法异常code */
    public static final Integer PARAMS_INVALIDATE_ERROR = 10101006;

    /** 信息过时 */
    public static final Integer INVALIDATE_DATE_ERROR = 10101007;

    /** 无效的同步锁 */
    public static final Integer INVALIDATE_SYNC_LOCK = 10101008;

    /** 不支持的编码 */
    public static final Integer UNSUPPORTED_ENCODING = 10101009;
    
    /** 方法调用异常 */
    public static final Integer METHOD_CALL_ERROR = 10102001;

    /** 参数错误 */
    public static final Integer PRARM_ERROR = 10109998;

    /** 未知错误 */
    public static final Integer UNKNOW_ERROR = 10109999;
    
    public BusinessException() {
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    @Override
    public String toString() {
        return "BusinessException [msg=" + msg + ", code=" + code + "]";
    }
}
