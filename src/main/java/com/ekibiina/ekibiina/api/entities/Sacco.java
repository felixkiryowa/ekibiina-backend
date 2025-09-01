package com.ekibiina.ekibiina.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "saccos")
@AllArgsConstructor
@NoArgsConstructor
public class Sacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "registration_number", unique = true)
    private String registrationNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number", unique = true)
    private String contactNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "website", unique = true)
    private String website;

}
