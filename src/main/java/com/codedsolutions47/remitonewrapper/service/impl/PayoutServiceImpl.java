package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.*;
import com.codedsolutions47.remitonewrapper.service.PayoutService;
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
public class PayoutServiceImpl implements PayoutService {

    private final OkHttpClient httpClient;
    private final UtilityService utilityService;


    @Value("${api.path.getPayoutTransactions}")
    private String getPayoutTransactionsPath;
    @Value("${api.path.acceptPayoutTransactions}")
    private String acceptPayoutTransactionsPath;
    @Value("${api.path.processPayoutTransaction}")
    private String processPayoutTransactionPath;
    @Value("${api.path.errorPayoutTransaction}")
    private String errorPayoutTransactionPath;

    @Value("${api.path.getPendingPayoutTransactions}")
    private String getPendingPayoutTransactionsPath;

    public PayoutServiceImpl(OkHttpClient httpClient, UtilityService utilityService) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
    }

    @Override
    public String getPayoutTransactions(GetPayoutTransactions getPayoutTransactions) {
        Map<String, Object> params = new HashMap<>();
        params.put("bank_name", getPayoutTransactions.getBankName());
        params.put("is_bank_name_prefix", getPayoutTransactions.getIsBankNamePrefix());
        params.put("limit", getPayoutTransactions.getLimit());
        Request request = utilityService.createRequest(getPayoutTransactionsPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected code getPayoutTransactionsPath {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received getPayoutTransactionsPath XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String acceptPayoutTransactions(AcceptTransaction acceptTransactions) {
        Map<String, Object> params = new HashMap<>();
        params.put("trans_ref", acceptTransactions.getTransactionRef());
        params.put("bank_name", acceptTransactions.getBankName());
        Request request = utilityService.createRequest(acceptPayoutTransactionsPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected code acceptPayoutTransactions {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received acceptPayoutTransactions XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String processPayoutTransaction(ProcessPayoutTransaction processPayoutTransaction) {
        Map<String, Object> params = new HashMap<>();
        params.put("trans_ref", processPayoutTransaction.getTransactionRef());
        params.put("pay_method", processPayoutTransaction.getPayMethod());
        Request request = utilityService.createRequest(processPayoutTransactionPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected processPayoutTransaction code {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received processPayoutTransaction XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String errorPayoutTransaction(ErrorPayoutTransaction errorPayoutTransaction) {
        Map<String, Object> params = new HashMap<>();
        params.put("trans_ref", errorPayoutTransaction.getTransactionRef());
        params.put("error_reason", errorPayoutTransaction.getErrorReason());
        params.put("error_details", errorPayoutTransaction.getErrorDetails());
        params.put("bank_name", errorPayoutTransaction.getBankName());
        Request request = utilityService.createRequest(errorPayoutTransactionPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected errorPayoutTransaction code {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return null;
            }
            String responseBodyString = responseBody.string();
            log.info("Received errorPayoutTransaction XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String getPendingPayoutTransactions(GetPendingPayoutTransactions getPendingPayoutTransactions) {
        Map<String, Object> params = new HashMap<>();
        params.put("bank_name", getPendingPayoutTransactions.getBankName());
        params.put("limit", getPendingPayoutTransactions.getLimit());
        Request request = utilityService.createRequest(getPendingPayoutTransactionsPath, params);
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
