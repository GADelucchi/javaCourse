package edu.coderhouse.postman.controllers;

import edu.coderhouse.postman.models.Cliente;
import edu.coderhouse.postman.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<Cliente>> getClientes() {
//        List<Cliente> clientes = clienteService.buscarClientes();
//        if (clientes.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(clientes);
//        }
//    }

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
