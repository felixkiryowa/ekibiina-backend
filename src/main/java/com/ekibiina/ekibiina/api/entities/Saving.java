package com.ekibiina.ekibiina.api.entities;

import com.ekibiina.ekibiina.api.enums.SavingType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "savings")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double interestRate;
    private Double amount;

    private LocalDateTime maturityDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "sacco_id", insertable = false, updatable = false)
    private Sacco sacco;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "saving_type", nullable = false)
    private SavingType savingType;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}

