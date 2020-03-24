package com.cq.wh.admin.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : WangHao
 * @Date: 2020-03-22 10:55
 * @Description : 用户管理
 */
@Api(value = "用户管理",tags = {"用户管理接口"})
@RestController("/user")
public class UserController {

    @ApiOperation(value = "用户信息输出接口")
    @GetMapping("/userInfo")
    public String useInfo(@ApiParam(name = "user",value = "用户",required = true)@RequestParam String user){
         return "yes, "+user;
    }

}
