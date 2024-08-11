package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;

@Data
public class SearchRemitter {
    private String beneficiaryId;
    private String linkedRemitterId;
    private String name;
    private String fname;
    private String lname;
    private String telephone;
    private String accountNumber;
    private String country;
}
