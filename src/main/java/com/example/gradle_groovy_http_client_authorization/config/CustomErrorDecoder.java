package com.example.gradle_groovy_http_client_authorization.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        //int status = response.status(); //second version for error handle
        HttpStatus httpStatus = HttpStatus.valueOf(response.status());
        switch(httpStatus){
        //switch (status){
            //case 401: return new OpenApiResourceNotFoundException("You need to authorize!");
            //case 404: return new OpenApiResourceNotFoundException("Bad request! Page not found!");
            //case 500: return new OpenApiResourceNotFoundException("Server side error! Contact with developer!");
            case NOT_FOUND: return new OpenApiResourceNotFoundException("Bad request! Page not found!");
            case INTERNAL_SERVER_ERROR: return new OpenApiResourceNotFoundException("Server side error! Contact with developer!");
            case UNAUTHORIZED: return new OpenApiResourceNotFoundException("You need to authorize!");
            default: return null;
        }
    }
}

