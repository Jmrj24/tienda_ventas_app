package com.example.proyect_tienda.service;

import com.example.proyect_tienda.model.Producto;

import java.util.List;

public interface IProductoService {

    public void saveProducto(Producto producto);

    public List<Producto> getAllProductos();

    public void deleteProducto(Long codigoProducto);

    public Producto findProducto(Long codigoProducto);

    public void editProducto(Producto producto);

    public List<Producto> getFaltaStock();
}
