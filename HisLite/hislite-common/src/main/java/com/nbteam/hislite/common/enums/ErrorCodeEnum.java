package com.nbteam.hislite.common.enums;

public enum ErrorCodeEnum {
	/*成功*/
	SUCESS(0,"成功"),
	/*安全错误代码10*/
	SEC_SES_EXPIRE(10001,"会话失效"),
	SEC_LACK_AUTH(10002,"缺乏授权"),
	SEC_LOGIN_FAILED(10003,"登录认证失败"),
	SEC_CODE_OTHER(10004,"验证码异常"),
	SEC_FORBIDDEN(10005,"权限不够拒绝访问"),
	SEC_ERROR_OTHER(10999,"安全未知异常"),
	
	/*业务异常11*/
	BSS_UPDATE_FAILED(11001,"数据修改异常"),
	BSS_CREATE_FAILED(11002,"创建数据异常"),
	BSS_QUERY_FAILED(11003,"数据查询异常"),
	BSS_DELTE_FAILED(11004,"数据删除异常"),
	/****数据为空异常****/
	BSS_EMPTY_FAILED(11005,"数据为空异常"),
	BSS_PARAM_FAILED(11006,"业务参数异常"),
	BSS_RULE_FAILED(11006,"不符合业务规则"),
	BSS_ERROR_OTHER(11999,"业务未知异常"),
	/*数据库异常代码12*/
	DB_CONNECTION_FAILED(12001,"数据库连接异常"),
	DB_ERROR_OTHER(12999,"数据库未知异常"),
	
	/*前端交互错误代码13*/	
	WEB_PARAM_FAILED(13001,"WEB参数异常"),
	WEB_ERROR_OTHER(13999,"WEB未知异常"),
	/*系统异常代码14*/
	SYS_SERV_NOT_EXSITED(14001,"服务不存在"),
	SYS_PORT_BINDING(14002,"端口绑定失败"),
	SYS_ERROR_OTHER(14999,"系统未知异常"),
	




	;

	
	private int errCode;
	private String message;
	ErrorCodeEnum(int code,String msg){
		this.errCode=code;
		this.message=msg;
	}
	public int getErrCode() {
		return errCode;
	}
	public String getMessage() {
		return message;
	}

}
