package com.example.gradle_groovy_http_client_authorization;

import com.example.gradle_groovy_http_client_authorization.services.StylesHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StylesHttpControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    StylesHttpClient stylesHttpClient;

    @Test
    void testStylesHttpControllerGetAllStylesWhenSuccess() throws Exception {
        mockMvc.perform(get("/gradle/http/get-all"))
                .andExpect(status().isOk());
    }

    @Test
    void testStylesHttpControllerGetAllStylesWhenReturnBadRequest() throws IOException {
        //GIVEN
        String expectThrowMessage = "You need to authorize!";

        //WHEN
        when(stylesHttpClient.getAllStyles()).thenThrow(new OpenApiResourceNotFoundException("You need to authorize!"));

        //THEN
        Assertions.assertEquals(expectThrowMessage, "You need to authorize!");
    }
}
