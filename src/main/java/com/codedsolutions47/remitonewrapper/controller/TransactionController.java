package com.codedsolutions47.remitonewrapper.controller;


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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            log.error("Error occurred in getDeliveryBanks: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


//    @PostMapping("/confirm")
//    public ResponseEntity<Void> confirmTransaction(@RequestParam String sessionId) {
//        // Call the service method to confirm a transaction
//        transactionService.confirmTransaction(sessionId);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/status/{transactionId}")
//    public ResponseEntity<TransactionStatus> getTransactionStatus(@PathVariable String transactionId) {
//        // Call the service method to get the transaction status
//        TransactionStatus status = transactionService.getTransactionStatus(transactionId);
//        return ResponseEntity.ok(status);
//    }


}
