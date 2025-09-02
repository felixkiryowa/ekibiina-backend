package com.ekibiina.ekibiina.api.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "members", indexes = {
        @Index(name = "idx_user_phone", columnList = "user_id, phone_number")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sacco_id", nullable = false)
    private Sacco sacco;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name = "monthly_income")
    private Long monthlyIncome;

    @Column(name = "occupation", length = 50)
    private String occupation;

    @Column(name = "bank", length = 100)
    private String bank;

    @Column(name = "account_number", length = 50)
    private String accountNumber;

    @Column(name = "signature", length = 255)
    private String signature;

    @Column(name = "id_type", length = 50)
    private String idType;

    @Column(name = "id_number", length = 50)
    private String idNumber;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "payment_member_preference_id")
    private Integer paymentMemberPreferenceId;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @Column(name = "next_of_kin", length = 100)
    private String nextOfKin;

    @Column(name = "shares")
    private Double shares;

    @Column(name = "comments", columnDefinition = "text")
    private String comments;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
