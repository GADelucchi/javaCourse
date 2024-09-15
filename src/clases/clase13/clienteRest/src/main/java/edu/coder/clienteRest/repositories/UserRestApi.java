package edu.coder.clienteRest.repositories;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class UserRestApi {

    public List getUsuarios() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.getForObject(url, List.class);
    }

    public String getUserById(String idUsuario) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        final String urlById = url + "/" + idUsuario;
        return restTemplate.getForObject(urlById, String.class);
    }

    public String guardarUsuario(String user) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.postForObject(url, user, String.class);
    }
}
