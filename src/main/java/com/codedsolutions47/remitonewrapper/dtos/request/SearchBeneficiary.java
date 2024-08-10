package com.codedsolutions47.remitonewrapper.dtos.request;

import lombok.Data;

@Data
public class SearchBeneficiary {
    private int beneficiary_id;
    private int linked_remitter_id;
    private String name;
    private String fname;
    private String mname;
    private String lname;
    private String address_line1;
    private String city;
    private String postcode;
    private String country;
    private String dob;
    private String email;
    private String telephone;
    private String mobile;
    private String id_details;
    private String id2_details;
    private String account_number;
    private String card_number;
    private String enabled;
}
