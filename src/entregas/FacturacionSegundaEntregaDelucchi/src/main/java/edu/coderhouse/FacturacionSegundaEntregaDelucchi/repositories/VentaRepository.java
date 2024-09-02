package edu.coderhouse.FacturacionSegundaEntregaDelucchi.repositories;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
