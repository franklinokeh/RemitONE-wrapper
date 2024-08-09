package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.ConfirmTransaction;
import com.codedsolutions47.remitonewrapper.dtos.request.CreateTransaction;

public interface TransactionService {
    String createTransaction(CreateTransaction createTransaction);

    String confirmTransaction(ConfirmTransaction confirmTransaction);

    String getTransactionStatus(String reference);
}
