package com.codedsolutions47.remitonewrapper.controller;

import com.codedsolutions47.remitonewrapper.dtos.request.CreateBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchBeneficiary;
import com.codedsolutions47.remitonewrapper.dtos.request.UpdateBeneficiary;
import com.codedsolutions47.remitonewrapper.service.BeneficiaryService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beneficiaries")
@Slf4j
@RequiredArgsConstructor
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;
    private final UtilityService utilityService;

    @PostMapping
    public ResponseEntity<JsonNode> createBeneficiary(@RequestBody CreateBeneficiary createBeneficiaryRequest) {
        log.info(" ==== Entered CreateBeneficiaryRequest method ======  {}", PrettyPrinter.printJson(createBeneficiaryRequest));
        try {
            String response = beneficiaryService.createBeneficiary(createBeneficiaryRequest);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("createBeneficiary Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in createBeneficiaryRequest: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
//
    @GetMapping()
    public ResponseEntity<JsonNode> searchBeneficiary(SearchBeneficiary searchBeneficiary) {
        log.info(" ==== Entered searchBeneficiary method ======  {}", PrettyPrinter.printJson(searchBeneficiary));
        try {
            String response = beneficiaryService.searchBeneficiary(searchBeneficiary);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("searchBeneficiary Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in searchBeneficiary: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
//

    @PatchMapping()
    public ResponseEntity<JsonNode> updateBeneficiary(@RequestBody UpdateBeneficiary updateBeneficiary) {
        log.info(" ==== Entered updateBeneficiary method ======  {}", PrettyPrinter.printJson(updateBeneficiary));
        try {
            String response = beneficiaryService.updateBeneficiary(updateBeneficiary);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("updateBeneficiary Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in searchBeneficiary: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


}
