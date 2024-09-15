package edu.coder.swagger.controllers;

import edu.coder.swagger.models.Cliente;
import edu.coder.swagger.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Cliente", description = "Operaciones relacionadas con los clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar clientes", description = "Buscar todos los clientes en el sistema")
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = clienteService.buscarClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clientes);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Agregar cliente", description = "Agregar un cliente nuevo al sistema")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteGuardado = clienteService.crearCliente(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/cliente/{idCliente}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar cliente por ID", description = "Buscar un cliente por su número de ID en el sistema")
    public ResponseEntity<?> getClienteById(@PathVariable(name = "idCliente") Integer idCliente) {
        Optional<Cliente> cliente = clienteService.buscarClienteById(idCliente);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
