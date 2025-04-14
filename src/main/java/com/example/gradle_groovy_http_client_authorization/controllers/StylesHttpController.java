package com.example.gradle_groovy_http_client_authorization.controllers;

import com.example.gradle_groovy_http_client_authorization.services.StylesHttpClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/gradle/http")
public class StylesHttpController {

    private final StylesHttpClient stylesService;

    public StylesHttpController(StylesHttpClient stylesService) {
        this.stylesService = stylesService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllStyles() throws IOException {
        return new ResponseEntity<>(stylesService.getAllStyles(), HttpStatus.OK);
    }
}
