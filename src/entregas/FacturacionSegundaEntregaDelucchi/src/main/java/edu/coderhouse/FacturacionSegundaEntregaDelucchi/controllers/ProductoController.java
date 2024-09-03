package edu.coderhouse.FacturacionSegundaEntregaDelucchi.controllers;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Cliente;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Producto;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> productos = productoService.buscarProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(productos);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
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
    public ResponseEntity<?> getProductoById(@PathVariable(name = "idProducto") Integer idProducto) {
        Optional<Producto> producto = productoService.buscarProductoById(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
