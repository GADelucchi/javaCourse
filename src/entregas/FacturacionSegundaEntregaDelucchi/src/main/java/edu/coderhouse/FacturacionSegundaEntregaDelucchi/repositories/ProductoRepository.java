package edu.coderhouse.FacturacionSegundaEntregaDelucchi.repositories;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
