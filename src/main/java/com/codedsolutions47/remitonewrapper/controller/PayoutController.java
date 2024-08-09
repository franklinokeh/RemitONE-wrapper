package com.codedsolutions47.remitonewrapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payouts")
public class PayoutController {

//    @GetMapping("/transactions")
//    public ResponseEntity<List<PayoutTransaction>> getPayoutTransactions() {
//        // Call the service method to get payout transactions
//        List<PayoutTransaction> transactions = payoutService.getPayoutTransactions();
//        return ResponseEntity.ok(transactions);
//    }
//
//    @PostMapping("/accept")
//    public ResponseEntity<Void> acceptPayoutTransactions(@RequestBody List<Long> transactionIds) {
//        // Call the service method to accept payout transactions
//        payoutService.acceptPayoutTransactions(transactionIds);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/process")
//    public ResponseEntity<Void> processPayoutTransaction(@RequestBody Long transactionId) {
//        // Call the service method to process payout transaction
//        payoutService.processPayoutTransaction(transactionId);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/error")
//    public ResponseEntity<Void> errorPayoutTransaction(@RequestBody Long transactionId) {
//        // Call the service method to handle errors in payout transactions
//        payoutService.errorPayoutTransaction(transactionId);
//        return ResponseEntity.ok().build();
//    }


}
