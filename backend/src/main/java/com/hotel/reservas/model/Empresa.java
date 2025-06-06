package com.hotel.reservas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(unique = true, nullable = false)
    private String rut;

    private String nomFantasia;
    private String razonSocial;
}