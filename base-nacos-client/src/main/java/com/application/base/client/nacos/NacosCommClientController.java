package com.application.base.client.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: 孤狼
 * @desc:
 */
@Slf4j
@RestController
@RequestMapping("common")
public class NacosCommClientController {
	
	/**
	 * 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
	 */
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 获得 RestTemplate 对象.
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 测试服务.
	 * @param name
	 * @return
	 */
	@GetMapping("/sayHelloClient")
	public String sayHelloClient(@RequestParam String name) {
		//通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
		name = name==null?"孤狼":name;
		ServiceInstance serviceInstance = loadBalancerClient.choose("base-nacos-server");
		String url = serviceInstance.getUri() + "/base-nacos-server/server/sayHelloServer?name=" + name;
		String result = restTemplate.getForObject(url, String.class);
		return "Invoke : " + url + ", return : " + result;
	}
}
