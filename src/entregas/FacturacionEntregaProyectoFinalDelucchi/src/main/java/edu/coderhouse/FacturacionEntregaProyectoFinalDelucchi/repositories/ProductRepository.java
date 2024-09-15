package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
