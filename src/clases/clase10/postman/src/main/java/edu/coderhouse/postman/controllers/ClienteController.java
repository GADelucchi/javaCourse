package edu.coderhouse.postman.controllers;

import edu.coderhouse.postman.daos.DaoFactory;
import edu.coderhouse.postman.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private DaoFactory daoFactory;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = daoFactory.getClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clientes);
        }
    }

    @GetMapping(value = "/cliente/{idCliente}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name = "idCliente") Integer idCliente) {
        Cliente cliente = daoFactory.getClienteById(idCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cliente);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Object guardarCliente(@RequestBody Cliente cliente) {
        try {
            daoFactory.create(cliente);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
