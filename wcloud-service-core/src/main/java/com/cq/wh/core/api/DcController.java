package com.cq.wh.core.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wh
 * @Date: 2019/10/9 09:37
 * @Description:
 */
@RestController
@Api(value = "TestController",tags = {"无权限接口"})
@RequestMapping("/service-core")
public class DcController {

    @GetMapping("/dc")
    public String dc(){
        return "core --------- dc";
    }

    @ApiOperation(value = "测试接口")
    @GetMapping("authTest")
    public String authTest(@ApiParam(name = "name",value = "测试入参")@RequestParam String name){
        return "auth "+name;
    }
}
