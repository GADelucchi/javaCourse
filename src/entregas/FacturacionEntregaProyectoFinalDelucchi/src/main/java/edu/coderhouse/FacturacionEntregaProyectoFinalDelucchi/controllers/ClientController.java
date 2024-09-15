package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Client;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.getClients();
        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clients);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveClient(@Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            Client savedClient = clientService.createClient(client);
            return ResponseEntity.created(URI.create("/api/clients/" + savedClient.getIdClient())).body(savedClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/client/{idClient}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClientById(@PathVariable(name = "idClient") Integer idClient) {
        Optional<Client> client = clientService.findClientById(idClient);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
