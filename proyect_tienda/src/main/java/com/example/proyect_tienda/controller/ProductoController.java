package com.example.proyect_tienda.controller;

import com.example.proyect_tienda.model.Producto;
import com.example.proyect_tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoServi;

    // Crear un producto
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoServi.saveProducto(producto);
        return "Producto creado";
    }

    // Devolver todos los productos
    @GetMapping("/productos")
    public List<Producto> getAllProductos() {
        return productoServi.getAllProductos();
    }

    // Devolver un producto en especifico
    @GetMapping("/productos/{codigoProducto}")
    public Producto getProducto(@PathVariable Long codigoProducto) {
        return productoServi.findProducto(codigoProducto);
    }

    // Borrar un producto
    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public String deleteProducto(@PathVariable Long codigoProducto) {
        productoServi.deleteProducto(codigoProducto);
        return "Producto eliminado";
    }

    // Editar un producto
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto producto) {
        productoServi.editProducto(producto);
        return productoServi.findProducto(producto.getCodigoProducto());
    }

    // Devolver todos los productos con falta de stock( Stock menor a 5)
    @GetMapping("/productos/falta_stock")
    public List<Producto> getFaltaStock() {
        return productoServi.getFaltaStock();
    }
}
