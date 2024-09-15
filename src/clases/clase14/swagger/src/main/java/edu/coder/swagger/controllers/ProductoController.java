package edu.coder.swagger.controllers;

import edu.coder.swagger.models.Producto;
import edu.coder.swagger.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar productos", description = "Buscar todos los productos en el sistema")
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> productos = productoService.buscarProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(productos);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Agregar producto", description = "Agrega un producto nuevo al sistema")
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) {
        try {
            Producto productoGuardado = productoService.crearProducto(producto);
            return ResponseEntity.created(URI.create("")).body(productoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/producto/{idProducto}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar producto por ID", description = "Buscar un producto por su número de ID en el sistema")
    public ResponseEntity<?> getProductoById(@PathVariable(name = "idProducto") Integer idProducto) {
        Optional<Producto> producto = productoService.buscarProductoById(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
