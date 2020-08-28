package com.cq.wh.admin.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2InterceptedFeignConfiguration {

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Bean
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails(){
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        clientCredentialsResourceDetails.setClientId("internal");
        clientCredentialsResourceDetails.setClientSecret("internal");
        clientCredentialsResourceDetails.setAccessTokenUri("http://127.0.0.1:12000/oauth/token");
        return clientCredentialsResourceDetails;
    };

    @Bean(name = "oauth2RequestInterceptor")
    public RequestInterceptor getOAuth2RequestInterceptor() throws IOException {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }
}
