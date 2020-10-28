package com.nbteam.hislite.lhrm.api.exception;

import com.nbteam.hislite.common.exception.BusinessException;

/**
 * 
 * 支付中心异常信息（用户中心code范围为 1004xxxx）<br/>
 *
 */
public class HospitalException extends BusinessException {

    /** 
     */
    private static final long serialVersionUID = 1L;
    /** 医院网关异常 code */
    public static final Integer HOSCENTER_GATEWAY_ERROR = 20019999;
    /** 系统异常 */
    public static final Integer HOSCENTER_SYSTEM_ERROR = 20099999;
    /** 参数异常 */
    public static final Integer HOSCENTER_PARAM_ERROR = 20029999;
    
    /**  */
    public static final Integer MED_BIZ_ERROR = 10080000;

    public HospitalException() {
    }

    public HospitalException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    @Override
    public String toString() {
        return "PayCenterException [msg=" + msg + ", code=" + code + "]";
    }

}
