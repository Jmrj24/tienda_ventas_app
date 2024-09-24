package com.example.proyect_tienda.controller;

import com.example.proyect_tienda.dto.VentaClienteDTO;
import com.example.proyect_tienda.model.Producto;
import com.example.proyect_tienda.model.Venta;
import com.example.proyect_tienda.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaServi;

    // Crear un venta
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {
        return ventaServi.saveVenta(venta);
    }

    // Devolver todas las ventas
    @GetMapping("/ventas")
    public List<Venta> getAllVentas() {
        return ventaServi.getAllVentas();
    }

    // Devolver un venta en especifico
    @GetMapping("/ventas/{codigoVenta}")
    public Venta getVenta(@PathVariable Long codigoVenta) {
        return ventaServi.findVenta(codigoVenta);
    }

    // Borrar una venta
    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
    public String deleteVenta(@PathVariable Long codigoVenta) {
        ventaServi.deleteVenta(codigoVenta);
        return "Venta eliminada con exito";
    }

    // Editar una venta
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta venta) {
        ventaServi.editVenta(venta);
        return ventaServi.findVenta(venta.getCodigoVenta());
    }

    // Devolver todos los productos de una determinada venta
    @GetMapping("ventas/productos/{codigoVenta}")
    public List<Producto> getProductos(@PathVariable Long codigoVenta) {
        return ventaServi.getProductos(codigoVenta);
    }

    // Devolver sumatoria total de ventas y cantidad de ventas de un determinado dia
    @GetMapping("/ventas/total_fecha/{fechaVenta}")
    public String getVentasFecha(@PathVariable LocalDate fechaVenta) {
        return ventaServi.getVentasFecha(fechaVenta);
    }

    // Devolver el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
    //apellido del cliente de la venta con el monto más alto de todas
    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO mayorVenta() {
        return ventaServi.mayorVenta();
    }
}
