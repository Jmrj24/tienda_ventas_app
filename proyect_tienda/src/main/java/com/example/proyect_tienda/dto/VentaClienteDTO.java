package com.example.proyect_tienda.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    private Long codigoVenta;
    private double totalVenta;
    private double cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigoVenta, double totalVenta, double cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.totalVenta = totalVenta;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}
