package com.codedsolutions47.remitonewrapper.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRemitter {

    // Mandatory fields
    private String firstname; // *
    private String lastname; // *
    private String type; // * (registered / basicregistered)
    private String status; // * (valid / expired / blocked)
    private String address1; // *
    private String city; // *

    // Optional fields
    private String middlename;
    private String nationality; // 2 letter country ISO code
    private String visaStatus; // Values must be one of setting “VISA_STATUS_LIST”
    private String gender; // Male / Female
    private String comments;
    private String address2;
    private String state;
    private String postcode;
    private String email;
    private String telephone;
    private String mobile;
    private LocalDate dob; // Required if type is 'registered'
    private String placeOfBirth;
    private String countryOfBirth; // 2 letter country ISO code
    private String fathersName;
    private String mothersName;
    private String nationalIdNumber;
    private String idType; // Required if type is 'registered'
    private String idDetails; // Required if type is 'registered'
    private String idIssuedBy; // Required if type is 'registered'
    private String idIssuePlace; // Required if type is 'registered'
    private String idIssueCountry;
    private LocalDate idStart; // Required if type is 'registered'
    private LocalDate idExpiry; // Required if type is 'registered'
}
