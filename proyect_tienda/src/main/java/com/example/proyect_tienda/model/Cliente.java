package com.example.proyect_tienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String apellido, String dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
