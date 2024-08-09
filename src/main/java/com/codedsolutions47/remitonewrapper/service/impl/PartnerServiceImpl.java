package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.service.PartnerService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class PartnerServiceImpl implements PartnerService {

    private final OkHttpClient httpClient;
    @Value("${BASE_URL}")
    private String baseUrl;
    @Value("${ACCESS_USERNAME}")
    private String accessUsername;
    @Value("${ACCESS_PASSWORD}")
    private String accessPassword;
    @Value("${ACCESS_PIN}")
    private String accessPin;
    @Value("${api.path.destinationCountries}")
    private String destinationCountriesPath;

    public PartnerServiceImpl(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public String getDestinationCountries() {
        RequestBody requestBody = new FormBody.Builder()
                .add("username", accessUsername)
                .add("password", accessPassword)
                .add("pin", accessPin)
                .build();
        Request request = new Request.Builder()
                .url(baseUrl + destinationCountriesPath)
                .post(requestBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        log.info("Getting destination countries -- username: {}, password: {}, pin: {}", accessUsername, accessPassword, accessPin);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected code {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                log.error("Response body is null");
                return null;
            }
            String responseBodyString = responseBody.string(); // Read and store the response body as a string
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }


    @Override
    public String getDeliveryInfo() {
        return "";
    }
}
