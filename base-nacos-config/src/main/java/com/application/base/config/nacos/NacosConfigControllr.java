package com.application.base.config.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孤狼
 * @desc: 测试 nacos 配置的管理实现.
 */
@Slf4j
@RefreshScope
@RestController("config")
public class NacosConfigControllr {
	
	@Value("${default-key:}")
	private String defaultKey;
	@Value("${default-value:}")
	private String defaultValue;
	
	/**
	 * 访问地址:
	 *      http://127.0.0.1:8001/base-nacos-config/config/getSetProps
	 * @return
	 */
	@GetMapping("/getSetProps")
	public String getSetProps() {
		log.info("the  default-key=" + defaultKey+",default-value="+defaultValue);
		return "the  default-key=" + defaultKey+",default-value="+defaultValue;
	}
	
}