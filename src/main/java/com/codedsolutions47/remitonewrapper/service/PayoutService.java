package com.codedsolutions47.remitonewrapper.service;

import com.codedsolutions47.remitonewrapper.dtos.request.*;

public interface PayoutService {
    String getPayoutTransactions(GetPayoutTransactions getPayoutTransactions);

    String acceptPayoutTransactions(AcceptTransaction acceptTransactions);

    String processPayoutTransaction(ProcessPayoutTransaction processPayoutTransaction);

    String errorPayoutTransaction(ErrorPayoutTransaction errorPayoutTransaction);

    String getPendingPayoutTransactions(GetPendingPayoutTransactions getPendingPayoutTransactions);
}
