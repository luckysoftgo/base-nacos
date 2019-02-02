package com.application.base.client.nacos.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 孤狼
 * @desc: 指定要调用的服务
 */
@FeignClient(value="base-nacos-server",path = "/base-nacos-server/server")
public interface FeignClientService {
	
	/**
	 * 调用注册中心的服务.
	 * @param name
	 * @return
	 */
	@GetMapping("/sayHelloServer")
	String sayHelloServer(@RequestParam(name = "name") String name);
	
}
