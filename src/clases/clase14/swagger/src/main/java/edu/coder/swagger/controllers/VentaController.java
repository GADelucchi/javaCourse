package edu.coder.swagger.controllers;

import edu.coder.swagger.models.Venta;
import edu.coder.swagger.services.VentaService;
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
@RequestMapping("/api/ventas")
@Tag(name = "Ventas", description = "Operaciones relacionadas con los ventas")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar ventas", description = "Buscar todos los ventas en el sistema")
    public ResponseEntity<List<Venta>> getProductos() {
        List<Venta> ventas = ventaService.buscarVentas();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ventas);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Agregar venta", description = "Agrega una venta nueva al sistema")
    public ResponseEntity<?> guardarVenta(@RequestBody Venta venta) {
        try {
            Venta ventaGuardado = ventaService.crearVenta(venta);
            return ResponseEntity.created(URI.create("")).body(ventaGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/venta/{idVenta}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Buscar venta por ID", description = "Buscar una venta por su número de ID en el sistema")
    public ResponseEntity<?> getVentaById(@PathVariable(name = "idVenta") Integer idVenta) {
        Optional<Venta> venta = ventaService.buscarVentaById(idVenta);
        if (venta.isPresent()) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
