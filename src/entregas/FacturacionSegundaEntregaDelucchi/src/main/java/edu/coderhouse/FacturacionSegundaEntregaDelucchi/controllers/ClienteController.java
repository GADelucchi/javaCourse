package edu.coderhouse.FacturacionSegundaEntregaDelucchi.controllers;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Cliente;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente/{idCliente}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name = "idCliente") Integer idCliente) {
        Optional<Cliente> cliente = clienteService.buscarClienteById(idCliente);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteGuardado = clienteService.crearCliente(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
