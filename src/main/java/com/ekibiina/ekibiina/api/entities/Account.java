package com.ekibiina.ekibiina.api.entities;

import com.ekibiina.ekibiina.api.enums.AccountType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minimumMembershipPeriod;

    @Column(name = "account_number", length = 50)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "payment_integration", length = 50)
    private String paymentIntegration;

    private Double balance = 0.0;

    @Column(length = 50)
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "sacco_id", insertable = false, updatable = false)
    private Sacco sacco;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Member member;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}

