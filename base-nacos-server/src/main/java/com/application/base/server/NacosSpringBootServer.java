package com.application.base.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 孤狼
 * @desc: nacos 以springboot的方式启动运行.
 * @EnableDiscoveryClient: 服务可以被nacos或者eurke发现
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosSpringBootServer {
	
	/**
	 * 启动服务
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NacosSpringBootServer.class,args);
	}
}
