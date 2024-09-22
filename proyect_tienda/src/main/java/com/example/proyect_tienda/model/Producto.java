package com.example.proyect_tienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantidadDisponible;

    public Producto() {
    }

    public Producto(Long codigoProducto, String nombre, String marca, Double costo, double cantidadDisponible) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }
}
