package com.codedsolutions47.remitonewrapper.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Beneficiary")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String fname;
    private String mname;
    private String lname;
    private String organisationType;
    private String companyName;
    private String companyType;
    private String companyRegNo;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String nationality;
    private String dob;
    private String fathersName;
    private String mothersName;
    private String nationalIdNumber;
    private String gender;
    private String telephone;
    private String mobile;
    private String email;
    private String idType;
    private String idDetails;
    private String idStart;
    private String idExpiry;
    private String idIssuedBy;
    private String idIssuePlace;
    private String idIssueCountry;
    private String idScan;
    private String id2Type;
    private String id2Details;
    private String id2Expiry;
    private String id2IssuePlace;
    private String benefEmployerIdDetails;
    private String benefTaxpayerReg;
    private String benefOccupation;
    private String cardType;
    private String cardNumber;
    private String accountNumber;
    private String bank;
    private String bankBranch;
    private String bankBranchCity;
    private String bankBranchState;
    private String bankBranchTelephone;
    private String bankBranchManager;
    private String benefBankSwiftCode;
    private String benefBankIfscCode;
    private String benefBankIbanCode;
    private String benefBankAccountName;
    private String benefAcType;
    private String homedeliveryNotes;
    private String enabled;
    private String suspicious;
    private String suspicionReason;
    private int linkedMemberId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiary_id")
    @ToString.Exclude
    private List<Remitter> remitters;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Transaction> transactions;



}
