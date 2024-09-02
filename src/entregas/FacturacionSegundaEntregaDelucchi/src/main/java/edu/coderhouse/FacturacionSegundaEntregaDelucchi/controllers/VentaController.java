package edu.coderhouse.FacturacionSegundaEntregaDelucchi.controllers;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Venta;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping(value = "/venta/{idVenta}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getVentaById(@PathVariable(name = "idVenta") Integer idVenta) {
        Optional<Venta> venta = ventaService.buscarVentaById(idVenta);
        if (venta.isPresent()) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> guardarVenta(@RequestBody Venta venta) {
        try {
            Venta ventaGuardado = ventaService.crearVenta(venta);
            return ResponseEntity.created(URI.create("")).body(ventaGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
