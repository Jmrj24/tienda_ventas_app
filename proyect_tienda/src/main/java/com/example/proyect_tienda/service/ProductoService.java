package com.example.proyect_tienda.service;

import com.example.proyect_tienda.model.Producto;
import com.example.proyect_tienda.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void deleteProducto(Long codigoProducto) {
        productoRepo.deleteById(codigoProducto);
    }

    @Override
    public Producto findProducto(Long codigoProducto) {
        return productoRepo.findById(codigoProducto).orElse(null);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> getFaltaStock() {
        List<Producto> listaProductos = this.getAllProductos();
        List<Producto> listaFaltaStock = new ArrayList<Producto>();

        for (Producto producto : listaProductos) {
            if(producto.getCantidadDisponible()<5) {
                listaFaltaStock.add(producto);
            }
        }
        return listaFaltaStock;
    }
}
