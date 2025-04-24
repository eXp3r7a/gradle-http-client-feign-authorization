package com.example.gradle_groovy_http_client_authorization;

import com.example.gradle_groovy_http_client_authorization.models.StyleErrorMessage;
import com.example.gradle_groovy_http_client_authorization.models.StylesResponse;
import com.example.gradle_groovy_http_client_authorization.services.StylesHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StyleHttpClientServiceTest {


    @Mock
    private StylesHttpClient stylesHttpClient;

    @Mock
    CloseableHttpClient mockClient;

    @Mock
    HttpResponse mockResponse;

    @Test
    public void testGetAllStylesWhenSuccessful() throws IOException {
        //GIVEN
        StylesResponse expectedClass = new StylesResponse();
        when(stylesHttpClient.getAllStyles()).thenReturn(expectedClass);

        //WHEN
        Object actualReturn = stylesHttpClient.getAllStyles();

        //THEN
        assertTrue(actualReturn instanceof StylesResponse);
    }

    @Test
    public void testGetAllStylesWhenFailed() throws IOException {
        //GIVEN
        StyleErrorMessage expectedClass = new StyleErrorMessage();
        when(stylesHttpClient.getAllStyles()).thenReturn(expectedClass);

        //WHEN
        Object actualReturn = stylesHttpClient.getAllStyles();

        //THEN
        assertTrue(actualReturn instanceof StyleErrorMessage);
    }
}
