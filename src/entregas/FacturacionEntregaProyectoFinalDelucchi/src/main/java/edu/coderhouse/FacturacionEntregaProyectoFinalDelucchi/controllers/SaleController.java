package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Sale;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")

public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Sale>> getSales() {
        List<Sale> sales = saleService.getSales();
        if (sales.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(sales);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveSale(@Valid @RequestBody Sale sale, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            Sale savedSale = saleService.createSale(sale);
            return ResponseEntity.created(URI.create("/api/sales/" + savedSale.getIdSale())).body(savedSale);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/sale/{idSale}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<?> getSaleById(@PathVariable(name = "idSale") Integer idSale) {
        Optional<Sale> sale = saleService.findSaleById(idSale);
        if (sale.isPresent()) {
            // Calcular el total antes de devolver la respuesta
            Sale saleWithTotal = saleService.calculateTotal(sale.get());
            return ResponseEntity.ok(saleWithTotal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
