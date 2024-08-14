package com.codedsolutions47.remitonewrapper.dtos.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmTransaction {
    private String transactionId;
}
