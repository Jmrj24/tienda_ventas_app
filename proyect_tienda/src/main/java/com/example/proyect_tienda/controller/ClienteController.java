package com.example.proyect_tienda.controller;

import com.example.proyect_tienda.model.Cliente;
import com.example.proyect_tienda.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clienteServi;

    // Crear un Cliente
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteServi.saveCliente(cliente);
        return "Cliente Creado";
    }

    // Devolver todos los clientes
    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteServi.getAllClientes();
    }

    // Devolver un cliente en especifico
    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente) {
        return clienteServi.findCliente(idCliente);
    }

    // Borrar un Cliente
    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public String deleteCliente(@PathVariable Long idCliente) {
        clienteServi.deleteCliente(idCliente);
        return "Cliente eliminado";
    }

    // Editar un Cliente
    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente cliente) {
        clienteServi.editCliente(cliente);
        return clienteServi.findCliente(cliente.getIdCliente());
    }

}
