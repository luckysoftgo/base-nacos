package com.application.base.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 孤狼
 * @desc: nacos 测试的 springboot 客户端.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosSpringBootClient {
	
	/**
	 * 启动程序.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NacosSpringBootClient.class,args);
	}
	
}
