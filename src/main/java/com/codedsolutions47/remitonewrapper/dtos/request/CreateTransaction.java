package com.codedsolutions47.remitonewrapper.dtos.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTransaction {
    private Long remitterId;
    private Long beneficiaryId;
    private String relationToRemitter;
    private String destinationCountry;
    private String agentTransRef;
    private String benefTransRef;
    private String transType;
    private String purpose;
    private String sourceOfIncome;
    private Long collectionPointId;
    private String collectionPoint;
    private String collectionPointCode;
    private String collectionPointBank;
    private String collectionPointAddress;
    private String collectionPointCity;
    private String collectionPointState;
    private String collectionPointTelephone;
    private String benefIdType;
    private String benefIdDetails;
    private Long collectionPin;
    private String benefUtilityBillCompany;
    private String benfUtilityBillAddress1;
    private String benfUtilityBillAddress2;
    private String benfUtilityBillAddress3;
    private String benfUtilityBillCity;
    private String benfUtilityBillState;
    private String benfUtilityBillPostcode;
    private String benefUtilityBillAccountNo;
    private String benefUtilityBillInvoice;
    private String benefUtilityBillBank;
    private String benefUtilityBillBankCode;
    private String benefUtilityBillBankBic;
    private String benefUtilityBillDescription;
    private String benefMobileTransferNumber;
    private Long benefMobileTransferNetworkId;
    private String benefMobileTransferNetwork;
    private String benefMobileTransferNetworkCreditTypeId;
    private String paymentMethod;
    private Double amountDeposited;
    private LocalDate dateDeposited;
    private String bankBranchDeposited;
    private String remitterWalletCurrency;
    private String serviceLevel;
    private Boolean smsConfirmation;
    private Boolean smsNotification;
    private String smsMobile;
    private Boolean smsBenefConfirmation;
    private String smsBenefMobile;
    private String sourceCurrency;
    private String destCurrency;
    private String amountType;
    private Double amountToSend;
    private String agentComments;
    private Double rate;
    private Double commission;
    private Double commissionHqFromPartnerAmount;
    private String commissionHqFromPartnerCurrency;
}
