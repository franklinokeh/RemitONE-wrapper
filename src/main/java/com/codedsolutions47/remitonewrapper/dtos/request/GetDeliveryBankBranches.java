package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;

@Data
public class GetDeliveryBankBranches {
    private String deliveryBank;
    private String destinationCountry;
    private String destinationCountryCode;
}
