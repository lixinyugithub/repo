package com.nbteam.hislite.common.enums;

public enum StateEnum {
	ENABLE(1,"有效"),            //有效
	DISABLE(0,"已删除"),
	;
	private short code;
	private String name;	

    StateEnum(int code,String name) {
		this.code = (short) code;
		this.name = name;	
	}

	public short getCode() {
		return code;
	}

	public void setCode(short code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
