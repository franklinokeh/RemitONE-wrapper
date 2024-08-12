package com.codedsolutions47.remitonewrapper.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorPayoutTransaction {
    private String transactionRef;
    private String errorReason;
    private String errorDetails;
    private String bankName;
}
