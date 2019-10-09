package com.cq.wh.admin.client.fallback;

import com.cq.wh.admin.client.CoreFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Auther: wh
 * @Date: 2019/10/9 11:15
 * @Description:
 */
@Component
public class CoreServiceFallBack implements CoreFeignClient {
    @Override
    public String dc() {
        return "dc error";
    }
}
