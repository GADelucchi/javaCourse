package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
