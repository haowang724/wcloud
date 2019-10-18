package com.cq.wh.core.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wh
 * @Date: 2019/10/9 09:37
 * @Description:
 */
@RestController
@RequestMapping("/service-core")
public class DcController {

    @GetMapping("/dc")
    public String dc(){
        return "core --------- dc";
    }
}
