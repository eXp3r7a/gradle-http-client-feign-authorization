package com.example.gradle_groovy_http_client_authorization;

import com.example.gradle_groovy_http_client_authorization.config.CustomErrorDecoder;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomErrorDecoderTest {

    private final CustomErrorDecoder decoder = new CustomErrorDecoder();

    private Response createFakeResponse(int status) {
        return Response.builder()
                .status(status)
                .reason("Fake Reason")
                .request(Request.create(Request.HttpMethod.GET, "http://test", Collections.emptyMap(), null, null, null))
                .headers(Collections.emptyMap())
                .build();
    }

    @Test
    void testDecodeReturnsUnauthorizedException() {
        Response response = createFakeResponse(HttpStatus.UNAUTHORIZED.value());

        Exception ex = decoder.decode("testMethod", response);

        assertTrue(ex instanceof OpenApiResourceNotFoundException);
        assertEquals("You need to authorize!", ex.getMessage());
    }

    @Test
    void testDecodeReturnsNotFoundException() {
        Response response = createFakeResponse(HttpStatus.NOT_FOUND.value());

        Exception ex = decoder.decode("testMethod", response);

        assertTrue(ex instanceof OpenApiResourceNotFoundException);
        assertEquals("Bad request! Page not found!", ex.getMessage());
    }

    @Test
    void testDecodeReturnsServerErrorException() {
        Response response = createFakeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception ex = decoder.decode("testMethod", response);

        assertTrue(ex instanceof OpenApiResourceNotFoundException);
        assertEquals("Server side error! Contact with developer!", ex.getMessage());
    }

    @Test
    void testDecodeReturnsNullForUnhandledStatus() {
        Response response = createFakeResponse(HttpStatus.BAD_REQUEST.value());

        Exception ex = decoder.decode("testMethod", response);

        assertNull(ex); //return null if not explicitly handled
    }
}
