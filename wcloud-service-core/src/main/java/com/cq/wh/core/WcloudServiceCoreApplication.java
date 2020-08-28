package com.cq.wh.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class WcloudServiceCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcloudServiceCoreApplication.class, args);
	}

	@Bean
	@Qualifier("loadBalancedRestTemplate")
	public RestTemplate loadBalancedRestTemplate(RestTemplateCustomizer customizer) {
		RestTemplate restTemplate = new RestTemplate();
		customizer.customize(restTemplate);
		return restTemplate;
	}

}
