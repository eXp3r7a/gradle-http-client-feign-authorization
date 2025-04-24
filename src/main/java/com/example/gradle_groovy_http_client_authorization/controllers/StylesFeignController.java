package com.example.gradle_groovy_http_client_authorization.controllers;

import com.example.gradle_groovy_http_client_authorization.models.StylesResponse;
import com.example.gradle_groovy_http_client_authorization.services.StylesFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gradle/feign")
public class StylesFeignController {

    private final StylesFeignClient stylesFeignClient;

    public StylesFeignController(StylesFeignClient stylesFeignClient) {
        this.stylesFeignClient = stylesFeignClient;
    }

    @GetMapping("/get-all")
    public ResponseEntity<StylesResponse> getAllStyles(){
        return new ResponseEntity<>(stylesFeignClient.getAllStyles(), HttpStatus.OK);
    }
}
