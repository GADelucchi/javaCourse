package edu.coder.clienteRest.controllers;

import edu.coder.clienteRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsers() {
        List<String> users = userService.getUsuarios();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{idUsuario}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUserById(@PathVariable(name = "idUsuario") String idUsuario) {
        String user = userService.getUsuarioById(idUsuario);
        return ResponseEntity.ok(user);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postUser(@RequestBody String user) {
        String userGuardado = userService.guardarUsuario(user);
        return ResponseEntity.created(null).body(userGuardado);
    }
}
