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


}
