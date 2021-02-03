package com.cq.wh.wcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WcloudEurekaApplication.class, args);
    }

}
