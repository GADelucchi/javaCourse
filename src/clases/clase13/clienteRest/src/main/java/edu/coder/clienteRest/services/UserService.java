package edu.coder.clienteRest.services;

import edu.coder.clienteRest.repositories.UserRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRestApi userRestApi;

    public List getUsuarios() {
        return userRestApi.getUsuarios();
    }

    public String getUsuarioById(String idUsuario) {
        return userRestApi.getUserById(idUsuario);
    }

    public String guardarUsuario(String user) {
        return userRestApi.guardarUsuario(user);
    }
}
