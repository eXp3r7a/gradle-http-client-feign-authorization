package com.example.gradle_groovy_http_client_authorization.services;

import com.example.gradle_groovy_http_client_authorization.config.StylesFeignConfig;
import com.example.gradle_groovy_http_client_authorization.models.StylesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stylesClient", url = "https://api.iconfinder.com", configuration = StylesFeignConfig.class)
public interface StylesFeignClient {

    @GetMapping("/v4/styles")
    StylesResponse getAllStyles();
}
