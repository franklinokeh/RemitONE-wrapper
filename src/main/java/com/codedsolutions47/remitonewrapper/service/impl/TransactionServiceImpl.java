package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.ConfirmTransaction;
import com.codedsolutions47.remitonewrapper.dtos.request.CreateTransaction;
import com.codedsolutions47.remitonewrapper.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public String createTransaction(CreateTransaction createTransaction) {
        return "";
    }

    @Override
    public String confirmTransaction(ConfirmTransaction confirmTransaction) {
        return "";
    }

    @Override
    public String getTransactionStatus(String reference) {
        return "";
    }
}
