package com.codedsolutions47.remitonewrapper.controller;


import com.codedsolutions47.remitonewrapper.dtos.request.ConfirmTransaction;
import com.codedsolutions47.remitonewrapper.dtos.request.CreateTransaction;
import com.codedsolutions47.remitonewrapper.service.PartnerService;
import com.codedsolutions47.remitonewrapper.service.TransactionService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@Slf4j
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final UtilityService utilityService;


    @PostMapping
    public ResponseEntity<JsonNode> createTransaction(@RequestBody CreateTransaction createTransaction) {
        log.info(" ====  Entered createTransaction method =====  {}", PrettyPrinter.printJson(createTransaction));
        try {
            String response = transactionService.createTransaction(createTransaction);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("getDeliveryInfo Response: {}", PrettyPrinter.printJson(jsonResponse));
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception ex) {
            log.error("Error occurred in createTransaction: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @PostMapping("/confirm")
    public ResponseEntity<JsonNode> confirmTransaction(@RequestBody ConfirmTransaction confirmTransaction) {
        log.info(" ====  Entered confirmTransaction method =====  {}", PrettyPrinter.printJson(confirmTransaction));
        try {
            String response = transactionService.confirmTransaction(confirmTransaction);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("confirmTransaction Response: {}", PrettyPrinter.printJson(jsonResponse));
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

//
    @GetMapping("/status/{reference}")
    public ResponseEntity<JsonNode> getTransactionStatus(@PathVariable String reference) {
        log.info(" ====  Entered getTransactionStatus method =====  {}", reference);
        try {
            String response = transactionService.getTransactionStatus(reference);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(response);
            if (jsonResponse != null) {
                log.info("getTransactionStatus Response: {}", PrettyPrinter.printJson(jsonResponse));
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
