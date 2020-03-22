package com.cq.wh.core.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : WangHao
 * @Date: 2020-03-22 09:21
 * @Description : 测试类
 */
@Api(value = "TestController",tags = {"测试接口"})
@RestController("/test")
public class TestController {

    @ApiOperation(value = "测试接口")
    @GetMapping("workTest")
    public String workTest(@ApiParam(name = "name",value = "测试入参")@RequestParam String name){
        return "work "+name;
    }

}
