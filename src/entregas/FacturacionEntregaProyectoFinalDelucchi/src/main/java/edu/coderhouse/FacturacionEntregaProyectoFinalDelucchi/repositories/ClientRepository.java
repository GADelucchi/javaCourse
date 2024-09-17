package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
