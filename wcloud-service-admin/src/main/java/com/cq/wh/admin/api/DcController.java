package com.cq.wh.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wh
 * @Date: 2019/10/9 09:31
 * @Description:
 */
@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc(){
        return  restTemplate.getForObject("http://eureka-service-core/dc",String.class);
    }
}
