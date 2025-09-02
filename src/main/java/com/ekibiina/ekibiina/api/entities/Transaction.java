package com.ekibiina.ekibiina.api.entities;

import com.ekibiina.ekibiina.api.enums.PaymentMethod;
import com.ekibiina.ekibiina.api.enums.TransactionStatus;
import com.ekibiina.ekibiina.api.enums.TransactionType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Column(name = "tran_description")
    private String tranDescription;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; // SAVINGS, LOAN

    private String narrations;
    private String reference;

    @Column(name = "transaction_reference")
    private String transactionReference;

    private String gatewayStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // e.g., CASH, MOBILE_MONEY, BANK

    private String currency;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "transaction")
    private List<Balance> balances;

    @ManyToOne
    @JoinColumn(name = "sacco_id", insertable = false, updatable = false)
    private Sacco sacco;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;
}

