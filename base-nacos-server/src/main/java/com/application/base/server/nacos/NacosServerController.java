package com.application.base.server.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孤狼
 * @desc: 测试nacos的访问
 */
@Slf4j
@RestController
@RequestMapping("server")
public class NacosServerController {
	
	/**
	 * 访问地址:
	 *      http://127.0.0.1:8001/base-nacos-server/server/sayHelloServer?name=bruce
	 * @param name
	 * @return
	 */
	@GetMapping("/sayHelloServer")
	public String sayHelloServer(@RequestParam String name) {
		log.info("Hello :" + name);
		return "Hello :" + name;
	}
	
}
