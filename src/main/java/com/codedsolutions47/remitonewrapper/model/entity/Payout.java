package com.codedsolutions47.remitonewrapper.model.entity;

import com.codedsolutions47.remitonewrapper.model.enums.PayoutStatus;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Payout")
public class Payout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trans_ref", nullable = false)
    private String transRef;

    @Column(name = "agent_trans_ref", nullable = false)
    private String agentTransRef;

    @Column(name = "benef_trans_ref", nullable = false)
    private String benefTransRef;

    @Column(name = "status", nullable = false)
    private PayoutStatus status;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "source_of_income", nullable = false)
    private String sourceOfIncome;

    @Column(name = "processing_bank", nullable = false)
    private String processingBank;

    @Column(name = "bank_accept_date")
    private Timestamp bankAcceptDate;

    @Column(name = "bank_branch_name")
    private String bankBranchName;

    @Column(name = "bank_branch_code")
    private String bankBranchCode;

    @Column(name = "bank_branch_accept_date")
    private Timestamp bankBranchAcceptDate;

    @Column(name = "delivery_date", nullable = false)
    private Timestamp deliveryDate;

    @Column(name = "processed_date")
    private Timestamp processedDate;

    @Column(name = "processed_by")
    private String processedBy;

    @Column(name = "trans_type", nullable = false)
    private String transType;

    @Column(name = "benef_id", nullable = false)
    private Long benefId;
}

