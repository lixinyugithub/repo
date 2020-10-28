package com.nbteam.hislite.zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {
	/***
	 * 
	* @Title: accessFilter 
	* @Description: 网关权限认证拦截
	* @param   输入参数
	* @return AccessFilter    返回类型 
	* @throws
	 */
	@Bean
    public ZuulAccessFilter accessFilter() {
        return new ZuulAccessFilter();
    }
}
