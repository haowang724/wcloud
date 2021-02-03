package com.cq.wh.wclouduaa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @USER wh
 * @DATE 2020/7/1
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("getUser")
    public String getUser(String name) {
        return "user: " + name;
    }
}
