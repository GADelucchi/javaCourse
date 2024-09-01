package edu.coderhouse.postman.repositories;

import edu.coderhouse.postman.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
