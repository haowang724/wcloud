package com.cq.wh.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @USER wh
 * @DATE 2020/6/30
 * @Description
 */
@RequestMapping("/main")
@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/login")
    public String login(@RequestBody  Map<String, String> params){
        String url = "http://uaa/oauth/token";
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String authorization = "web-app:web-secret";
        reqHeaders.add("Authorization","Basic " + Base64Utils.encodeToString(authorization.getBytes(StandardCharsets.UTF_8)));
        MultiValueMap<String, String> formParams = new LinkedMultiValueMap<>();
        formParams.set("username", params.get("username"));
        formParams.set("password", params.get("password"));
        formParams.set("grant_type", "password");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formParams, reqHeaders);
        ResponseEntity<String>
                responseEntity = restTemplate.postForEntity(url, entity, String.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new HttpClientErrorException(responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
