package edu.coderhouse.postman.services;

import edu.coderhouse.postman.models.Cliente;
import edu.coderhouse.postman.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClienteById(Integer idCliente) {
        return clienteRepository.findById(idCliente);
    }

//    public Cliente buscarClientes() {
//        return clienteRepository.findAll();
//    }
}
