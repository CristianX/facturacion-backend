package com.cristianx.backend_facturacion.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String email;

    private String direccion;

    private String telefono;
}