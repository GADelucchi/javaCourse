package edu.coder.swagger.services;

import edu.coder.swagger.models.Producto;
import edu.coder.swagger.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> buscarProductos() {
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarProductoById(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }
}
