package com.cq.wh.gateway.api;

import com.cq.wh.gateway.config.GateWaySwaggerResourcesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.*;

import java.util.List;

/**
 * @Author : WangHao
 * @Date: 2020-03-22 15:20
 * @Description : swagger资源接口类
 */
@RestController
@RequestMapping("/swagger-resources")
public class SwaggerResourceController {

    private GateWaySwaggerResourcesProvider swaggerResourceProvider;

    @Autowired
    public SwaggerResourceController(GateWaySwaggerResourcesProvider swaggerResourceProvider) {
        this.swaggerResourceProvider = swaggerResourceProvider;
    }

    @RequestMapping(value = "/configuration/security")
    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return new ResponseEntity<>(SecurityConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/configuration/ui")
    public ResponseEntity<UiConfiguration> uiConfiguration() {
        return new ResponseEntity<>(UiConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(swaggerResourceProvider.get(), HttpStatus.OK);
    }
}
