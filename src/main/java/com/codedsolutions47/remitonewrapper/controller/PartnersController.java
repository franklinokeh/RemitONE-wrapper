package com.codedsolutions47.remitonewrapper.controller;


import com.codedsolutions47.remitonewrapper.dtos.request.GetCollectionPoints;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBankBranches;
import com.codedsolutions47.remitonewrapper.dtos.request.GetDeliveryBanks;
import com.codedsolutions47.remitonewrapper.service.PartnerService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partners")
@Slf4j
@RequiredArgsConstructor
public class PartnersController {

    private final PartnerService partnersService;
    private final UtilityService utilityService;

    // Obtain a list of valid destination countries
    @GetMapping("/destinationCountries")
    public ResponseEntity<JsonNode> getDestinationCountries() {
        log.info(" ====  Entered getDestinationCountries method ===== ");
        String response = partnersService.getDestinationCountries();
        JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
        if (jsonResponse != null) {
            log.info("getDestinationCountries Response: {}", PrettyPrinter.printJson(jsonResponse));
            log.info(" ====  Exit getDestinationCountries method ===== ");
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


    // Obtain delivery entity information
    @GetMapping("/deliveryBanks")
    public ResponseEntity<JsonNode> getDeliveryBanks(GetDeliveryBanks getDeliveryBanks) {
        log.info(" ==== Entered getDeliveryBanks method ======  {}", PrettyPrinter.printJson(getDeliveryBanks));
        try {
            String response = partnersService.getDeliveryBanks(getDeliveryBanks);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("getDeliveryInfo Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in getDeliveryBanks: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Obtain getDeliveryBankBranches entity information
    @GetMapping("/deliveryBankBranches")
    public ResponseEntity<JsonNode> getDeliveryBankBranches(GetDeliveryBankBranches getDeliveryBankBranches) {
        log.info(" ==== Entered getDeliveryBankBranches method ======  {}", PrettyPrinter.printJson(getDeliveryBankBranches));
        try {
            String response = partnersService.getDeliveryBankBranches(getDeliveryBankBranches);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("getDeliveryBankBranches Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in getDeliveryBanks: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Obtain collectionPoints entity information
    @GetMapping("/collectionPoints")
    public ResponseEntity<JsonNode> getCollectionPoints(GetCollectionPoints getCollectionPoints) {
        log.info(" ==== Entered getCollectionPoints method ======  {}", PrettyPrinter.printJson(getCollectionPoints));
        try {
            String response = partnersService.getCollectionPoints(getCollectionPoints);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("getCollectionPoints Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in getDeliveryBanks: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


}
