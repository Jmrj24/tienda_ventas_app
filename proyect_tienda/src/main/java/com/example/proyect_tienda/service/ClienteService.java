package com.example.proyect_tienda.service;

import com.example.proyect_tienda.model.Cliente;
import com.example.proyect_tienda.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepo;

    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepo.findAll();
    }

    public void deleteCliente(Long idCliente) {
        clienteRepo.deleteById(idCliente);
    }

    public Cliente findCliente(Long idCliente) {
        return clienteRepo.findById(idCliente).orElse(null);
    }

    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }
}
