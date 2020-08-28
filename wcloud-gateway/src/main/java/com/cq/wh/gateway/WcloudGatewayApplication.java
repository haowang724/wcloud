package com.cq.wh.gateway;

import com.cq.wh.gateway.config.HeaderRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcloudGatewayApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplateBuilder builder = new RestTemplateBuilder();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("token", "123"));
		return builder.build();
	}

}
