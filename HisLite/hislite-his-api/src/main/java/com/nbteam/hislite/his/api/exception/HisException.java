package com.nbteam.hislite.his.api.exception;

import com.nbteam.hislite.common.exception.BusinessException;

/**
 * 
 * 门诊异常信息（用户中心code范围为 1004xxxx）<br/>
 *
 */
public class HisException extends BusinessException {



    public HisException() {
    }

    public HisException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

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

    public static final Integer PAY_CREATE_ORDER_EXCEPTION_CODE = 10101009;

    /**
     * 挂号中心未知错误
     */
    public static final int REGISTER_UNKNOWN_ERROR = 10121000;

    /**
     * 挂号中心数据库操作错误
     */
    public static final int REGISTER_DATABASE_ERROR = 10121100;

    /**
     * 挂号中心接口权限错误
     */
    public static final int REGISTER_INTF_RIGHT_ERROR = 10121200;

    /**
     * 挂号中心接口请求参数校验错误
     */
    public static final int REGISTER_INTF_REQUEST_PARAM_ERROR = 10121300;

    /**
     * 挂号中心接口业务逻辑错误
     */
    public static final int REGISTER_INTF_BIZ_ERROR = 10121400;

    /**
     * 挂号中心接口内部错误
     */
    public static final int REGISTER_INTF_INNER_ERROR = 10121500;



    /**
     * 未知系统异常
     */
    public static final int HIS_UNKNOWN_ERROR = 10030000;

    public static final int HIS_PARAM_NULL_ERROR = 10030001;

    public static final int HIS_BIZ_ERROR = 10031002;

    /**
     * 参数错误
     */
    public static final int PARAM_ERROR = 10031003;


    @Override
    public String toString() {
        return "HisException [msg=" + msg + ", code=" + code + "]";
    }
}
