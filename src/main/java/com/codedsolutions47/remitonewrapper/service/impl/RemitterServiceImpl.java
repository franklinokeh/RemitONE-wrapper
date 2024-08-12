package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.RemitterRequest;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;
import com.codedsolutions47.remitonewrapper.service.RemitterService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RemitterServiceImpl implements RemitterService {

    private final OkHttpClient httpClient;
    private final UtilityService utilityService;


    @Value("${api.path.createRemitter}")
    private String createRemitterPath;
    @Value("${api.path.searchRemitter}")
    private String searchRemitterPath;

    public RemitterServiceImpl(OkHttpClient httpClient, UtilityService utilityService) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
    }


    @Override
    public String createRemitter(RemitterRequest remitterRequest) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", remitterRequest.getFirstname());
        params.put("lastname", remitterRequest.getLastname());
        params.put("type", remitterRequest.getType());
        params.put("status", remitterRequest.getStatus());
        params.put("address1", remitterRequest.getAddress1());
        params.put("city", remitterRequest.getCity());
        Request request = utilityService.createRequest(createRemitterPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected code(createRemitterPath) {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                log.error("Response body is null");
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String searchRemitter(SearchRemitter searchRemitter) {
        Map<String, Object> params = new HashMap<>();
        params.put("beneficiaryId", searchRemitter.getBeneficiaryId());
        params.put("linkedRemitterId", searchRemitter.getLinkedRemitterId());
        params.put("name", searchRemitter.getName());
        params.put("fname", searchRemitter.getFname());
        params.put("lname", searchRemitter.getLname());
        params.put("telephone", searchRemitter.getTelephone());
        params.put("accountNumber", searchRemitter.getAccountNumber());
        params.put("country", searchRemitter.getCountry());
        Request request = utilityService.createRequest(searchRemitterPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected code(searchRemitterPath) {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received searchRemitter XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }
}
