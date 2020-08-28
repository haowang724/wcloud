package com.cq.wh.admin;

import com.cq.wh.admin.config.UserFeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WcloudServiceAdminApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return  restTemplateBuilder.build();
	}

	@Bean(name = "userFeignClientInterceptor")
	public RequestInterceptor getUserFeignClientInterceptor() throws IOException {
		return new UserFeignClientInterceptor();
	}
	public static void main(String[] args) {
		SpringApplication.run(WcloudServiceAdminApplication.class, args);
	}

}
