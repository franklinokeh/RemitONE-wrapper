package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;

@Data
public class GetPayoutTransactions {
    private String bankName;
    private String isBankNamePrefix;
    private String limit;
}
