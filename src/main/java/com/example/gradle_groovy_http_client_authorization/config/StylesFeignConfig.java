package com.example.gradle_groovy_http_client_authorization.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StylesFeignConfig {

    @Value("${styles.api.token}")
    private String stylesToken;

    @Bean
    public RequestInterceptor requestInterceptorStyles() {

        return requestTemplate ->  {
            requestTemplate.header("Authorization", "Bearer " + stylesToken);
        };
    }

    @Bean
    public ErrorDecoder errorDecoderStyles(){
        return new CustomErrorDecoder();
    }

}
