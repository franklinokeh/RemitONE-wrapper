package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.UpdateBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.response.CreateBeneficiaryXmlResponse;
import com.codedsolutions47.remitonewrapper.model.entity.Beneficiary;
import com.codedsolutions47.remitonewrapper.model.repository.BeneficiaryRepository;
import com.codedsolutions47.remitonewrapper.service.BeneficiaryService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
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
public class BeneficiaryServiceImpl implements BeneficiaryService {

    private final OkHttpClient httpClient;
    private final UtilityService utilityService;
    private final BeneficiaryRepository beneficiaryRepository;


    @Value("${api.path.createBeneficiary}")
    private String createBeneficiaryPath;
    @Value("${api.path.searchBeneficiary}")
    private String searchBeneficiaryPath;
    @Value("${api.path.updateBeneficiary}")
    private String updateBeneficiaryPath;

    public BeneficiaryServiceImpl(OkHttpClient httpClient, UtilityService utilityService, BeneficiaryRepository beneficiaryRepository1) {
        this.httpClient = httpClient;
        this.utilityService = utilityService;
        this.beneficiaryRepository = beneficiaryRepository1;
    }


    @Override
    public String createBeneficiary(CreateBeneficiary createBeneficiaryRequest) {
        Map<String, Object> params = new HashMap<>();

        // Basic Information
        params.put("name", createBeneficiaryRequest.getName());
        params.put("fname", createBeneficiaryRequest.getFname());
        params.put("mname", createBeneficiaryRequest.getMname());
        params.put("lname", createBeneficiaryRequest.getLname());
        params.put("organisation_type", createBeneficiaryRequest.getOrganisationType());
        params.put("company_name", createBeneficiaryRequest.getCompanyName());
        params.put("company_type", createBeneficiaryRequest.getCompanyType());
        params.put("company_reg_no", createBeneficiaryRequest.getCompanyRegNo());

        // Address Information
        params.put("address1", createBeneficiaryRequest.getAddress1());
        params.put("address2", createBeneficiaryRequest.getAddress2());
        params.put("address3", createBeneficiaryRequest.getAddress3());
        params.put("city", createBeneficiaryRequest.getCity());
        params.put("state", createBeneficiaryRequest.getState());
        params.put("postcode", createBeneficiaryRequest.getPostcode());
        params.put("country", createBeneficiaryRequest.getCountry());

        // Personal Information
        params.put("nationality", createBeneficiaryRequest.getNationality());
        params.put("dob", createBeneficiaryRequest.getDob());
        params.put("fathers_name", createBeneficiaryRequest.getFathersName());
        params.put("mothers_name", createBeneficiaryRequest.getMothersName());
        params.put("national_id_number", createBeneficiaryRequest.getNationalIdNumber());
        params.put("gender", createBeneficiaryRequest.getGender());
        params.put("telephone", createBeneficiaryRequest.getTelephone());
        params.put("mobile", createBeneficiaryRequest.getMobile());
        params.put("email", createBeneficiaryRequest.getEmail());

        // Identification Information
        params.put("id_type", createBeneficiaryRequest.getIdType());
        params.put("id_details", createBeneficiaryRequest.getIdDetails());
        params.put("id_start", createBeneficiaryRequest.getIdStart());
        params.put("id_expiry", createBeneficiaryRequest.getIdExpiry());
        params.put("id_issued_by", createBeneficiaryRequest.getIdIssuedBy());
        params.put("id_issue_place", createBeneficiaryRequest.getIdIssuePlace());
        params.put("id_issue_country", createBeneficiaryRequest.getIdIssueCountry());
        params.put("id_scan", createBeneficiaryRequest.getIdScan());

        // Second Identification Information
        params.put("id2_type", createBeneficiaryRequest.getId2Type());
        params.put("id2_details", createBeneficiaryRequest.getId2Details());
        params.put("id2_expiry", createBeneficiaryRequest.getId2Expiry());
        params.put("id2_issue_place", createBeneficiaryRequest.getId2IssuePlace());

        // Employment and Tax Information
        params.put("benef_employer_id_details", createBeneficiaryRequest.getBenefEmployerIdDetails());
        params.put("benef_taxpayer_reg", createBeneficiaryRequest.getBenefTaxpayerReg());
        params.put("benef_occupation", createBeneficiaryRequest.getBenefOccupation());

        // Banking Information
        params.put("card_type", createBeneficiaryRequest.getCardType());
        params.put("card_number", createBeneficiaryRequest.getCardNumber());
        params.put("account_number", createBeneficiaryRequest.getAccountNumber());
        params.put("bank", createBeneficiaryRequest.getBank());
        params.put("bank_branch", createBeneficiaryRequest.getBankBranch());
        params.put("bank_branch_city", createBeneficiaryRequest.getBankBranchCity());
        params.put("bank_branch_state", createBeneficiaryRequest.getBankBranchState());
        params.put("bank_branch_telephone", createBeneficiaryRequest.getBankBranchTelephone());
        params.put("bank_branch_manager", createBeneficiaryRequest.getBankBranchManager());
        params.put("benef_bank_swift_code", createBeneficiaryRequest.getBenefBankSwiftCode());
        params.put("benef_bank_ifsc_code", createBeneficiaryRequest.getBenefBankIfscCode());
        params.put("benef_bank_iban_code", createBeneficiaryRequest.getBenefBankIbanCode());
        params.put("benef_bank_account_name", createBeneficiaryRequest.getBenefBankAccountName());
        params.put("benef_ac_type", createBeneficiaryRequest.getBenefAcType());
        // Additional Information
        params.put("homedelivery_notes", createBeneficiaryRequest.getHomedeliveryNotes());
        params.put("enabled", createBeneficiaryRequest.getEnabled());
        params.put("suspicious", createBeneficiaryRequest.getSuspicious());
        params.put("suspicion_reason", createBeneficiaryRequest.getSuspicionReason());
        params.put("linked_member_id", String.valueOf(createBeneficiaryRequest.getLinkedMemberId()));
        Request request = utilityService.createRequest(createBeneficiaryPath, params);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Unexpected createRequest code {} with message {}", response.code(), response.message());
                return null;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                log.error("Response createRequest is null");
                return null;
            }
            String responseBodyString = responseBody.string();
            saveBeneficiary(createBeneficiaryRequest, responseBodyString);
            log.info("Received createRequest XML response from API - {}", responseBodyString);
            return responseBodyString;
        } catch (IOException | JAXBException e) {
            log.error("Error calling external API: ", e);
            return null;
        }
    }

    @Override
    public String searchBeneficiary(SearchBeneficiary searchBeneficiary) {
        Map<String, Object> params = new HashMap<>();
        params.put("beneficiary_id", searchBeneficiary.getBeneficiaryId());
        params.put("linked_remitter_id", searchBeneficiary.getLinkedRemitterId());
        params.put("mname", searchBeneficiary.getMname());
        params.put("fname", searchBeneficiary.getFname());
        params.put("lname", searchBeneficiary.getLname());
        Request request = utilityService.createRequest(searchBeneficiaryPath, params);
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
    public String updateBeneficiary(UpdateBeneficiary updateBeneficiary) {
        Map<String, Object> params = new HashMap<>();
        params.put("beneficiary_id", updateBeneficiary.getBeneficiaryId());
        params.put("mname", updateBeneficiary.getMname());
        params.put("fname", updateBeneficiary.getFname());
        params.put("lname", updateBeneficiary.getLname());
        Request request = utilityService.createRequest(updateBeneficiaryPath, params);
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
    public void saveBeneficiary(CreateBeneficiary createBeneficiary, String response) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CreateBeneficiaryXmlResponse xmlResponse = (CreateBeneficiaryXmlResponse) unmarshaller.unmarshal(new StringReader(response));
        if ("SUCCESS".equals(xmlResponse.getStatus())) {
            Long newBeneficiaryId = xmlResponse.getNewBeneficiaryId();
            Beneficiary beneficiary = beneficiaryRepository.findByBeneficiaryId(newBeneficiaryId).orElse(null);
            if(beneficiary != null) {
                log.error("User with remitterId {}", xmlResponse.getStatus());

            } else {
                beneficiary = new Beneficiary();
                beneficiary.setFname(createBeneficiary.getFname());
                beneficiary.setLname(createBeneficiary.getLname());
                beneficiary.setMname(createBeneficiary.getMname());
                beneficiary.setName(createBeneficiary.getName());
                beneficiary.setAccountNumber(createBeneficiary.getAccountNumber());
                beneficiary.setAddress1(createBeneficiary.getAddress1());
                beneficiary.setCity(createBeneficiary.getCity());
                beneficiary.setState(createBeneficiary.getState());
                beneficiary.setCountry(createBeneficiary.getCountry());
                beneficiary.setAddress2(createBeneficiary.getAddress2());
                beneficiary.setCardNumber(createBeneficiary.getCardNumber());
                beneficiary.setBeneficiaryId(newBeneficiaryId);
                beneficiaryRepository.save(beneficiary);
            }
        }
    }
}
