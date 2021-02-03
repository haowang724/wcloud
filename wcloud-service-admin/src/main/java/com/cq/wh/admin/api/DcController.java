package com.cq.wh.admin.api;

import com.cq.wh.admin.client.CoreFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wh
 * @Date: 2019/10/9 09:31
 * @Description:
 */
@Api(value = "测试接口", tags = {"测试接口"})
@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoreFeignClient coreFeignClient;

    @ApiOperation(value = "restTemplate调用dc")
    @GetMapping("/consumer")
    public String dc() {
        return restTemplate.getForObject("http://eureka-service-core/service-core/dc", String.class);
    }

    @ApiOperation(value = "fegin调用dc")
    @GetMapping("/dcFeign")
    public String dcFeign() {
        return coreFeignClient.dc();
    }

    @ApiOperation(value = "fegin调用workTest")
    @GetMapping("/workTestFeign")
    public String workTestFeign(String name) {
        return coreFeignClient.workTest(name);
    }


}
