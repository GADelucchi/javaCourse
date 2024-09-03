package edu.coderhouse.FacturacionSegundaEntregaDelucchi.services;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Cliente;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClienteById(Integer idCliente) {
        return clienteRepository.findById(idCliente);
    }
}
