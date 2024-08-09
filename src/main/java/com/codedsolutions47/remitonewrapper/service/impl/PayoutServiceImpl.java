package com.codedsolutions47.remitonewrapper.service.impl;

import com.codedsolutions47.remitonewrapper.dtos.request.*;
import com.codedsolutions47.remitonewrapper.service.PayoutService;
import org.springframework.stereotype.Service;

@Service
public class PayoutServiceImpl implements PayoutService {
    @Override
    public String getPayoutTransactions(GetPayoutTransactions getPayoutTransactions) {
        return "";
    }

    @Override
    public String acceptPayoutTransactions(AcceptTransaction acceptTransactions) {
        return "";
    }

    @Override
    public String processPayoutTransaction(ProcessPayoutTransaction processPayoutTransaction) {
        return "";
    }

    @Override
    public String errorPayoutTransaction(ErrorPayoutTransaction errorPayoutTransaction) {
        return "";
    }

    @Override
    public String getPendingPayoutTransactions(GetPendingPayoutTransactions getPendingPayoutTransactions) {
        return "";
    }


}
