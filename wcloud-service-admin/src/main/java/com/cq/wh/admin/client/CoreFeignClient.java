package com.cq.wh.admin.client;

import com.cq.wh.admin.client.fallback.CoreServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wh
 * @Date: 2019/10/9 10:51
 * @Description:
 */
@Component
@FeignClient(name = "eureka-service-core")
public interface CoreFeignClient {

    @GetMapping("/service-core/dc")
    String dc();

    @GetMapping("/core/workTest")
    String workTest(@RequestParam("name")String name);
}
