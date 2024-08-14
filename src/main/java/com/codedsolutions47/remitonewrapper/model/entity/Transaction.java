package com.codedsolutions47.remitonewrapper.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "remitter_id", nullable = false)
    @ToString.Exclude
    private Remitter remitter;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiary_id", nullable = false)
    @ToString.Exclude
    private Beneficiary beneficiary;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String requestPayload;


    private String agentTransRef;
    private String benefTransRef;
    private String transType;


    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String responsePayload;


    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;




}
