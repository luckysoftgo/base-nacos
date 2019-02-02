package com.application.base.client.nacos;

import com.application.base.client.nacos.api.FeignClientService;
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
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Author: 孤狼
 * @desc:
 */
@Slf4j
@RestController
@RequestMapping("webClient")
public class NacosWebfluxClientController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	/**
	 * 获得 RestTemplate 对象.
	 * @return
	 */
	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}
	
	/**
	 * 测试服务.
	 * @param name
	 * @return
	 */
	@GetMapping("/sayHelloClient")
	public Mono<String> sayHelloClient(@RequestParam String name) {
		Mono<String> result = webClientBuilder.build()
				.get()
				.uri("http://127.0.0.1:10001/base-nacos-server/server/sayHelloServer?name=bruce")
				.retrieve()
				.bodyToMono(String.class);
		return result;
	}
}
