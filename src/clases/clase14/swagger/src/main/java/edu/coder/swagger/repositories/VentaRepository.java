package edu.coder.swagger.repositories;

import edu.coder.swagger.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
