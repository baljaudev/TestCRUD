package com.neoris.PruebaCRUD.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    @Min(value = 0, message = "El precio no puede ser negativo")
    private BigDecimal precio;

    private String descripcion;
}
