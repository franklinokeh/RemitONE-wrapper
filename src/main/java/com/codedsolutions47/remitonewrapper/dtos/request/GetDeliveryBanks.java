package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;

@Data
public class GetDeliveryBanks {
    private String destCountry;
    private String countryCode;
    private String bankCode;
}
