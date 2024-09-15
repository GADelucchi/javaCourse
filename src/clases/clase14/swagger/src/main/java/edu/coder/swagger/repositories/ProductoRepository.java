package edu.coder.swagger.repositories;

import edu.coder.swagger.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
