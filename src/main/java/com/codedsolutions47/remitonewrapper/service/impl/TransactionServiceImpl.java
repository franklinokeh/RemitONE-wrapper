package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.ConfirmTransaction;
import com.codedsolutions47.remitonewrapper.dtos.request.CreateTransaction;
import com.codedsolutions47.remitonewrapper.service.TransactionService;
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
public class TransactionServiceImpl implements TransactionService {

    private final OkHttpClient httpClient;
    private final UtilityService utilityService;

    @Value("${api.path.createTransaction}")
    private String createTransactionPath;
    @Value("${api.path.confirmTransaction}")
    private String confirmTransactionPath;
    @Value("${api.path.getTransactionStatus}")
    private String getTransactionStatus;
    public TransactionServiceImpl(OkHttpClient httpClient, UtilityService utilityService) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
    }


    @Override
    public String createTransaction(CreateTransaction createTransaction) {
        Map<String, Object> params = new HashMap<>();
        //
        params.put("remitter_id", String.valueOf(createTransaction.getRemitterId()));
        params.put("beneficiary_id", String.valueOf(createTransaction.getBeneficiaryId()));
        params.put("relation_to_remitter", createTransaction.getRelationToRemitter());
        params.put("destination_country", createTransaction.getDestinationCountry());
        params.put("agent_trans_ref", createTransaction.getAgentTransRef());
        params.put("benef_trans_ref", createTransaction.getBenefTransRef());
        params.put("trans_type", createTransaction.getTransType());
        params.put("purpose", createTransaction.getPurpose());
        params.put("source_of_income", createTransaction.getSourceOfIncome());
        params.put("collection_point_id", String.valueOf(createTransaction.getCollectionPointId()));
        params.put("collection_point", createTransaction.getCollectionPoint());
        params.put("collection_point_code", createTransaction.getCollectionPointCode());
        params.put("collection_point_bank", createTransaction.getCollectionPointBank());
        params.put("collection_point_address", createTransaction.getCollectionPointAddress());
        params.put("collection_point_city", createTransaction.getCollectionPointCity());
        params.put("collection_point_state", createTransaction.getCollectionPointState());
        params.put("collection_point_telephone", createTransaction.getCollectionPointTelephone());
        params.put("benef_id_type", createTransaction.getBenefIdType());
        params.put("benef_id_details", createTransaction.getBenefIdDetails());
        params.put("collection_pin", String.valueOf(createTransaction.getCollectionPin()));
        params.put("benef_utilitybillcompany", createTransaction.getBenefUtilityBillCompany());
        params.put("benf_utilitybill_address1", createTransaction.getBenfUtilityBillAddress1());
        params.put("benf_utilitybill_address2", createTransaction.getBenfUtilityBillAddress2());
        params.put("benf_utilitybill_address3", createTransaction.getBenfUtilityBillAddress3());
        params.put("benf_utilitybill_city", createTransaction.getBenfUtilityBillCity());
        params.put("benf_utilitybill_state", createTransaction.getBenfUtilityBillState());
        params.put("benf_utilitybill_postcode", createTransaction.getBenfUtilityBillPostcode());
        params.put("benef_utilitybillaccountno", createTransaction.getBenefUtilityBillAccountNo());
        params.put("benef_utilitybillinvoice", createTransaction.getBenefUtilityBillInvoice());
        params.put("benef_utilitybillbank", createTransaction.getBenefUtilityBillBank());
        params.put("benef_utilitybillbankcode", createTransaction.getBenefUtilityBillBankCode());
        params.put("benef_utilitybillbankbic", createTransaction.getBenefUtilityBillBankBic());
        params.put("benef_utilitybilldescription", createTransaction.getBenefUtilityBillDescription());
        params.put("benef_mobiletransfer_number", createTransaction.getBenefMobileTransferNumber());
        params.put("benef_mobiletransfer_network_id", String.valueOf(createTransaction.getBenefMobileTransferNetworkId()));
        params.put("benef_mobiletransfer_network", createTransaction.getBenefMobileTransferNetwork());
        params.put("benef_mobiletransfer_network_credit_type_id", createTransaction.getBenefMobileTransferNetworkCreditTypeId());
        params.put("payment_method", createTransaction.getPaymentMethod());
        params.put("amount_deposited", String.valueOf(createTransaction.getAmountDeposited()));
        params.put("date_deposited", createTransaction.getDateDeposited() != null ? createTransaction.getDateDeposited().toString() : null);
        params.put("bank_branch_deposited", createTransaction.getBankBranchDeposited());
        params.put("remitter_wallet_currency", createTransaction.getRemitterWalletCurrency());
        params.put("service_level", createTransaction.getServiceLevel());
        params.put("sms_confirmation", String.valueOf(createTransaction.getSmsConfirmation()));
        params.put("sms_notification", String.valueOf(createTransaction.getSmsNotification()));
        params.put("sms_mobile", createTransaction.getSmsMobile());
        params.put("sms_benef_confirmation", String.valueOf(createTransaction.getSmsBenefConfirmation()));
        params.put("sms_benef_mobile", createTransaction.getSmsBenefMobile());
        params.put("source_currency", createTransaction.getSourceCurrency());
        params.put("dest_currency", createTransaction.getDestCurrency());
        params.put("amount_type", createTransaction.getAmountType());
        params.put("amount_to_send", String.valueOf(createTransaction.getAmountToSend()));
        params.put("agent_comments", createTransaction.getAgentComments());
        params.put("rate", String.valueOf(createTransaction.getRate()));
        params.put("commission", String.valueOf(createTransaction.getCommission()));
        params.put("commission_hq_from_partner_amount", String.valueOf(createTransaction.getCommissionHqFromPartnerAmount()));
        params.put("commission_hq_from_partner_currency", createTransaction.getCommissionHqFromPartnerCurrency());
        Request request = utilityService.createRequest(createTransactionPath, params);
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
    public String confirmTransaction(ConfirmTransaction confirmTransaction) {
        Map<String, Object> params = new HashMap<>();
        params.put("trans_session_id ", String.valueOf(confirmTransaction.getTransactionId()));
        //
        Request request = utilityService.createRequest(confirmTransactionPath, params);
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
    public String getTransactionStatus(String reference) {
        Map<String, Object> params = new HashMap<>();
        params.put("trans_ref ", reference);
        Request request = utilityService.createRequest(confirmTransactionPath, params);
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
