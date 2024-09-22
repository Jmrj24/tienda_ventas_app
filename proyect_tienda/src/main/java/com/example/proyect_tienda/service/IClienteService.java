package com.example.proyect_tienda.service;

import com.example.proyect_tienda.model.Cliente;

import java.util.List;

public interface IClienteService {
    // Crear Cliente
    public void saveCliente(Cliente cliente);

    // Traer Clientes
    public List<Cliente> getAllClientes();

    // Borrar Clientes
    public void deleteCliente(Long idCliente);

    // Traer un Cliente
    public Cliente findCliente(Long idCliente);

    // Modificar un Cliente
    public void editCliente(Cliente cliente);
}
