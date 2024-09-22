package com.example.proyect_tienda.service;

import com.example.proyect_tienda.dto.VentaClienteDTO;
import com.example.proyect_tienda.model.Producto;
import com.example.proyect_tienda.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public String saveVenta(Venta venta);

    public List<Venta> getAllVentas();

    public void deleteVenta(Long codigoVenta);

    public Venta findVenta(Long codigoVenta);

    public void editVenta(Venta venta);

    public List<Producto> getProductos(Long codigoVenta);

    public String getVentasFecha(LocalDate fechaVenta);

    public VentaClienteDTO mayorVenta();
}
