package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateRemitter;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;
import com.codedsolutions47.remitonewrapper.dtos.response.XmlResponse;
import com.codedsolutions47.remitonewrapper.exceptions.ApiException;
import com.codedsolutions47.remitonewrapper.exceptions.GlobalExceptionHandler;
import com.codedsolutions47.remitonewrapper.model.entity.Remitter;
import com.codedsolutions47.remitonewrapper.model.repository.RemitterRepository;
import com.codedsolutions47.remitonewrapper.service.RemitterService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RemitterServiceImpl implements RemitterService {

    private final OkHttpClient httpClient;
    private final UtilityService utilityService;
    private final RemitterRepository remitterRepository;


    @Value("${api.path.createRemitter}")
    private String createRemitterPath;
    @Value("${api.path.searchRemitter}")
    private String searchRemitterPath;

    public RemitterServiceImpl(OkHttpClient httpClient, UtilityService utilityService, RemitterRepository remitterRepository) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
        this.remitterRepository = remitterRepository;
    }


    @Override
    public String createRemitter(CreateRemitter remitterRequest) {
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
            saveRemitter(remitterRequest, responseBodyString);
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException | JAXBException e) {
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

    @Override
    public void saveRemitter(CreateRemitter createRemitter, String response) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XmlResponse xmlResponse = (XmlResponse) unmarshaller.unmarshal(new StringReader(response));
        // Check if the status is "SUCCESS"
        if ("SUCCESS".equals(xmlResponse.getStatus())) {
            Long newRemitterId = xmlResponse.getNewRemitterId();
            Remitter remitter = remitterRepository.findByRemitterId(newRemitterId).orElse(null);
            if (remitter != null) {
                remitter.setRemitterId(newRemitterId);
                remitterRepository.save(remitter);
            } else {
                remitter = new Remitter();
                remitter.setRemitterId(newRemitterId);
                remitter.setDob(createRemitter.getDob());
                remitter.setEmail(createRemitter.getEmail());
                remitter.setGender(createRemitter.getGender());
                remitter.setFirstname(createRemitter.getFirstname());
                remitter.setLastname(createRemitter.getLastname());
                remitter.setType(createRemitter.getType());
                remitter.setStatus(createRemitter.getStatus());
                remitter.setAddress1(createRemitter.getAddress1());
                remitter.setCity(createRemitter.getCity());
                remitterRepository.save(remitter);
            }
        } else {
            log.error("Error creating remitter: {}", xmlResponse.getStatus());
        }
    }
}
