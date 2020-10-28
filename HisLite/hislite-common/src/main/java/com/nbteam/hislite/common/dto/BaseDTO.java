package com.nbteam.hislite.common.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
 * 
 * @author yinzitang	
 * 所有DTO对象的父类
 */
public class BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2172453532806875051L;
	@Override 
    public String toString() { 
            return ReflectionToStringBuilder.toString(this); 
    }

}
