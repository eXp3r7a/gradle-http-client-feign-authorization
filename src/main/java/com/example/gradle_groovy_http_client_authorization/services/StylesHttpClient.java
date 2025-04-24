package com.example.gradle_groovy_http_client_authorization.services;

import com.example.gradle_groovy_http_client_authorization.models.StyleErrorMessage;
import com.example.gradle_groovy_http_client_authorization.models.StylesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class StylesHttpClient {

    @Value("${styles.api.token}")
    String token;

    public Object getAllStyles () throws IOException {
        String url = "https://api.iconfinder.com/v4/styles";



        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Bearer " + token);

            try (CloseableHttpResponse response = client.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String line;
                StringBuilder result = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                if(statusCode >= 200 && statusCode < 300){
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(result.toString(), StylesResponse.class);
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(result.toString(), StyleErrorMessage.class);
                }
            }
        }
    }
}
