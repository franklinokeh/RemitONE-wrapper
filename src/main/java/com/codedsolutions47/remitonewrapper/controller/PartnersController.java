package com.codedsolutions47.remitonewrapper.controller;


import com.codedsolutions47.remitonewrapper.service.PartnerService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.info("Entered getDestinationCountries method");
        String response = partnersService.getDestinationCountries();
        JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
        if (jsonResponse != null) {
            log.info("getDestinationCountries Response: {}", PrettyPrinter.printJson(jsonResponse));
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


    // Obtain delivery entity information
    @GetMapping("/deliveryInfo")
    public ResponseEntity<JsonNode> getDeliveryInfo() {
        log.info("Entered getDeliveryInfo method");
        String response = partnersService.getDeliveryInfo();
        JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
        if (jsonResponse != null) {
            log.info("getDeliveryInfo Response: {}", PrettyPrinter.printJson(jsonResponse));
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


}
