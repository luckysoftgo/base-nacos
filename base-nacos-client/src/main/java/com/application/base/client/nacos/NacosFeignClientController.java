package com.application.base.client.nacos;

import com.application.base.client.nacos.api.FeignClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孤狼
 * @desc:
 */
@Slf4j
@RestController
@RequestMapping("feign")
public class NacosFeignClientController {
	
	@Autowired
	FeignClientService feignClient;
	
	@GetMapping("/sayHelloClient")
	public String sayHelloClient(@RequestParam String name) {
		name=name==null?"bruce":name;
		String result = feignClient.sayHelloServer("bruce");
		return "Return : " + result;
	}
}
