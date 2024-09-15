package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Client;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientById(Integer idClient) {
        return clientRepository.findById(idClient);
    }
}
