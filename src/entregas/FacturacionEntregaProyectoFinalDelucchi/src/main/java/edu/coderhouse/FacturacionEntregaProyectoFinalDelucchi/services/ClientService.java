package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Client;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
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

    @Transactional
    public void deleteClientById(Integer idClient) {
        Optional<Client> client = clientRepository.findById(idClient);
        if (client.isPresent()) {
            clientRepository.deleteById(idClient);
        } else {
            throw new NoSuchElementException("Not found client with ID " + idClient);
        }
    }
}
