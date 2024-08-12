package com.codedsolutions47.remitonewrapper.controller;

import com.codedsolutions47.remitonewrapper.dtos.request.RemitterRequest;
import com.codedsolutions47.remitonewrapper.dtos.request.SearchRemitter;
import com.codedsolutions47.remitonewrapper.service.RemitterService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/remitters")
@Slf4j
@RequiredArgsConstructor
public class RemitterController {

    // TODO  log on Database

    private final RemitterService remitterService;
    private final UtilityService utilityService;

    @PostMapping
    public ResponseEntity<JsonNode> createRemitter(@RequestBody RemitterRequest request) {
        log.info(" ==== Entered getCollectionPoints method ======  {}", PrettyPrinter.printJson(request));
        try {
            String response = remitterService.createRemitter(request);
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


    @GetMapping()
    public ResponseEntity<JsonNode> searchRemitter(SearchRemitter searchRemitter) {
        log.info(" ==== Entered searchRemitter method ======  {}", PrettyPrinter.printJson(searchRemitter));
        try {
            String response = remitterService.searchRemitter(searchRemitter);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("searchRemitter Response: {}", PrettyPrinter.printJson(jsonResponse));
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
