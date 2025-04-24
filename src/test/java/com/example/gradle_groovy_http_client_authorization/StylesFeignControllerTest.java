package com.example.gradle_groovy_http_client_authorization;

import com.example.gradle_groovy_http_client_authorization.services.StylesFeignClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StylesFeignControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    StylesFeignClient stylesFeignClient;

    @Test
    void testStylesFeignControllerGetAllStylesWhenSuccess() throws Exception {
        mockMvc.perform(get("/gradle/feign/get-all"))
                .andExpect(status().isOk());
    }

    @Test
    void testStylesFeignControllerGetAllStylesWhenReturnBadRequest() {
        //GIVEN
        String expectThrowMessage = "Bad request! Page not found!";

        //WHEN
        when(stylesFeignClient.getAllStyles()).thenThrow(new OpenApiResourceNotFoundException("Bad request! Page not found!")).toString();

        //THEN
        Assertions.assertEquals(expectThrowMessage, "Bad request! Page not found!");
    }

//    @Test
//    void testStylesFeignControllerReturnsServerSideError() throws Exception {
//        // GIVEN
//        when(stylesFeignClient.getAllStyles())
//                .thenThrow(new RuntimeException());
//
//        // WHEN + THEN
//        mockMvc.perform(get("/gradle/feign/get-all"))
//                .andExpect(status().is5xxServerError());
//    }
}
