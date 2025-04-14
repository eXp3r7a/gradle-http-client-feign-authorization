package com.example.gradle_groovy_http_client_authorization;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Get All Styles", description = "All styles"))
public class GradleGroovyHttpClientAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleGroovyHttpClientAuthorizationApplication.class, args);
	}

}
