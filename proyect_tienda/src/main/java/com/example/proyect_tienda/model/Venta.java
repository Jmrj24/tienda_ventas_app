package com.example.proyect_tienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long codigoVenta;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaVenta;
    private double total;
    @ManyToMany
    private List<Producto> listaProductos;
    @ManyToOne
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
}
