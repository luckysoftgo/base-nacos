package com.application.base.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 孤狼
 * @desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSpringBootConfig {
	
	/**
	 * nacos 配置web配置检查入口.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NacosSpringBootConfig.class, args);
	}

}
