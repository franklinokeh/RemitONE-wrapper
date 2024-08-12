package com.codedsolutions47.remitonewrapper.service.impl;


import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class UtilityServiceImpl implements UtilityService {

    @Value("${BASE_URL}")
    private String baseUrl;
    @Value("${ACCESS_USERNAME}")
    private String accessUsername;
    @Value("${ACCESS_PASSWORD}")
    private String accessPassword;
    @Value("${ACCESS_PIN}")
    private String accessPin;

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public Request createRequest(String path, Map<String, Object> additionalParams) {
        log.info("Creating request for endpoint: {} with params {}", path, additionalParams);
        FormBody.Builder formBuilder = new FormBody.Builder()
                .add("username", accessUsername)
                .add("password", accessPassword)
                .add("pin", accessPin);
        if (additionalParams != null) {
            for (Map.Entry<String, Object> entry : additionalParams.entrySet()) {
                if (entry.getValue() != null) {
                    formBuilder.add(entry.getKey(), (String) entry.getValue());
                }
            }
        }
        RequestBody requestBody = formBuilder.build();
        return new Request.Builder()
                .url(baseUrl + path)
                .post(requestBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
    }


    @Override
    public JsonNode getXMLResponseAsJson (String xmlResponse) {
        try {
            JsonNode jsonNode = xmlMapper.readTree(xmlResponse.getBytes());
//            String prettyJson = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
//            log.info("Converted XML to JSON: {}", prettyJson);
            return jsonNode;
        } catch (IOException e) {
            log.error("Error converting XML to JSON: ", e);
            return null;
        }
    }

}
