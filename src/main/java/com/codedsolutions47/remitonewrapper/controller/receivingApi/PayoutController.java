package com.codedsolutions47.remitonewrapper.controller.receivingApi;

import com.codedsolutions47.remitonewrapper.dtos.request.*;
import com.codedsolutions47.remitonewrapper.service.PayoutService;
import com.codedsolutions47.remitonewrapper.service.UtilityService;
import com.codedsolutions47.remitonewrapper.util.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payouts")
@Slf4j
@RequiredArgsConstructor
public class PayoutController {

    private final PayoutService payoutService;
    private final UtilityService utilityService;


    @GetMapping("/transactions")
    public ResponseEntity<JsonNode> getPayoutTransactions(GetPayoutTransactions getPayoutTransactions) {
        log.info(" ====  Entered getPayoutTransactions method =====   {} ", PrettyPrinter.printJson(getPayoutTransactions));
        try {
            String transactions = payoutService.getPayoutTransactions(getPayoutTransactions);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(transactions);
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


    @GetMapping("/pending-transactions")
    public ResponseEntity<JsonNode> getPendingPayoutTransactions(GetPendingPayoutTransactions getPendingPayoutTransactions) {
        log.info(" ====  Entered getPendingPayoutTransactions method =====   {} ", PrettyPrinter.printJson(getPendingPayoutTransactions));
        try {
            String transactions = payoutService.getPendingPayoutTransactions(getPendingPayoutTransactions);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(transactions);
            if (jsonResponse != null) {
                log.info("getPendingPayoutTransactions Response: {}", PrettyPrinter.printJson(jsonResponse));
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
    @PostMapping("/accept")
    public ResponseEntity<JsonNode> acceptPayoutTransactions(@RequestBody AcceptTransaction acceptTransactions) {
        log.info(" ====  Entered acceptTransactions method =====   {} ", PrettyPrinter.printJson(acceptTransactions));
        try {
            String transactions = payoutService.acceptPayoutTransactions(acceptTransactions);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(transactions);
            if (jsonResponse != null) {
                log.info("acceptTransactions Response: {}", PrettyPrinter.printJson(jsonResponse));
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


    @PostMapping("/process")
    public ResponseEntity<JsonNode> processPayoutTransaction(@RequestBody ProcessPayoutTransaction processPayoutTransaction) {
        log.info(" ====  Entered processPayoutTransaction method =====   {} ", PrettyPrinter.printJson(processPayoutTransaction));
        try {
            String transactions = payoutService.processPayoutTransaction(processPayoutTransaction);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(transactions);
            if (jsonResponse != null) {
                log.info("processPayoutTransaction Response: {}", PrettyPrinter.printJson(jsonResponse));
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


    @PostMapping("/error")
    public ResponseEntity<JsonNode> errorPayoutTransaction(@RequestBody ErrorPayoutTransaction errorPayoutTransaction) {
        log.info(" ====  Entered errorPayoutTransaction method =====   {} ", PrettyPrinter.printJson(errorPayoutTransaction));
        try {
            String transactions = payoutService.errorPayoutTransaction(errorPayoutTransaction);
            JsonNode jsonResponse = utilityService.getXMLResponseAsJson(transactions);
            if (jsonResponse != null) {
                log.info("errorPayoutTransaction Response: {}", PrettyPrinter.printJson(jsonResponse));
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
