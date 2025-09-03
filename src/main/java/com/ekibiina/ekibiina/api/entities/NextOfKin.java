package com.ekibiina.ekibiina.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "next_of_kin", indexes = {
        @Index(name = "idx_member_id", columnList = "member_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NextOfKin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String relationship;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @Column(length = 50, nullable = false)
    private String occupation;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(name = "current_village", length = 100, nullable = false)
    private String currentVillage;

    @Column(name = "current_subcounty", length = 100, nullable = false)
    private String currentSubcounty;

    @Column(name = "current_district", length = 100, nullable = false)
    private String currentDistrict;

    @Column(name = "permanent_village", length = 100, nullable = false)
    private String permanentVillage;

    @Column(name = "permanent_subcounty", length = 100, nullable = false)
    private String permanentSubcounty;

    @Column(name = "permanent_district", length = 100, nullable = false)
    private String permanentDistrict;

    @Column(length = 255)
    private String signature;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
