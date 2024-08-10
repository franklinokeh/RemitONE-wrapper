package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.GetCollectionPoints;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBankBranches;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBanks;
import com.codedsolutions47.remitonewrapper.service.PartnerService;
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
    @Value("${api.path.deliveryBanks}")
    private String deliveryBanksPath;
    @Value("${api.path.deliveryBankBranches}")
    private String deliveryBankBranchesPath;
    @Value("${api.path.collectionPoints}")
    private String collectionPointsPath;

    private final UtilityService utilityService;

    public PartnerServiceImpl(OkHttpClient httpClient, UtilityService utilityService) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
    }


    @Override
    public String getDestinationCountries() {
        Map<String, String> params = new HashMap<>();
        Request request = utilityService.createRequest(destinationCountriesPath, params);
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
    public String getDeliveryBanks(GetDeliveryBanks getDeliveryBanks) {
        Map<String, String> params = new HashMap<>();
        params.put("dest_country", getDeliveryBanks.getDestCountry());
        params.put("country_code", getDeliveryBanks.getCountryCode());
        params.put("bank_code", getDeliveryBanks.getBankCode());
        Request request = utilityService.createRequest(deliveryBanksPath, params);
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
            String responseBodyString = responseBody.string();
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String getDeliveryBankBranches(GetDeliveryBankBranches getDeliveryBankBranches) {
        Map<String, String> params = new HashMap<>();
        params.put("delivery_bank", getDeliveryBankBranches.getDeliveryBank());
        params.put("destination_country", getDeliveryBankBranches.getDestinationCountry());
        params.put("destination_country_code", getDeliveryBankBranches.getDestinationCountryCode());
        Request request = utilityService.createRequest(deliveryBankBranchesPath, params);
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
            String responseBodyString = responseBody.string();
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String getCollectionPoints(GetCollectionPoints getCollectionPoints) {
        Map<String, String> params = new HashMap<>();
        params.put("delivery_bank", getCollectionPoints.getDeliveryBank());
        params.put("destination_country", getCollectionPoints.getDestinationCountry());
        params.put("destination_country_code", getCollectionPoints.getDestinationCountryCode());
        Request request = utilityService.createRequest(collectionPointsPath, params);
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
            String responseBodyString = responseBody.string();
            log.info("Received XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }
}
