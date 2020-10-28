package com.nbteam.hislite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication  //禁用一些启动配置
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy
public class ZuulApp {
	/***
	 * 
	* @Title: main 
	* @Description: 启动入口  
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}

}
