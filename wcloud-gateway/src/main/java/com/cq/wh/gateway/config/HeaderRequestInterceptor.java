package com.cq.wh.gateway.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @USER wh
 * @DATE 2020/6/30
 * @Description
 */
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

    private final String headerName;

    private final String headerValue;

    public HeaderRequestInterceptor(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().set(headerName, headerValue);
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
