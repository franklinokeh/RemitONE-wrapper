package com.codedsolutions47.remitonewrapper.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Remitter")
public class Remitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname;
    private String lastname;
    private String type;
    private String status;
    private String address1;
    private String city;
    private String nationality;
    private String gender;
    private String state;
    private String postcode;
    private String email;
    private String telephone;
    private String mobile;
    private LocalDate dob;
    private String placeOfBirth;
    private String countryOfBirth;
    private String fathersName;
    private String mothersName;
    private String nationalIdNumber;
    private int remitterId;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id", nullable = false)
    private Beneficiary beneficiary;

}
