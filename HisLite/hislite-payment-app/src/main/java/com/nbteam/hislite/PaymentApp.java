package com.nbteam.hislite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //服务注册与发现
@EnableFeignClients   //允许远程调用
@EnableCircuitBreaker
public class PaymentApp {

	/***
	 * 
	* @Title: main 
	* @Description: 启动入口  
	* @param   args
	* @return void    返回类型 
	* @throws
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaymentApp.class, args);
	}
}
