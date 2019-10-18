package com.cq.wh.admin.client;

import com.cq.wh.admin.client.fallback.CoreServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: wh
 * @Date: 2019/10/9 10:51
 * @Description:
 */
@Component
@FeignClient(name = "eureka-service-core",fallback = CoreServiceFallBack.class)
public interface CoreFeignClient {

    @GetMapping("/service-core/dc")
    String dc();
}
