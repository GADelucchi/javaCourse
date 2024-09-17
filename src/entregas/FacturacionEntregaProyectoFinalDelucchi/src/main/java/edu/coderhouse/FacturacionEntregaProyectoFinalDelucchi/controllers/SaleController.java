package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.ProductSale;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Sale;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.SaleService;
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
@RequestMapping("/api/sales")
@Tag(name = "SaleController")

public class SaleController {

    @Autowired
    private SaleService saleService;

    @Operation(summary = "Getting all sales", description = "Allows to get all sales in the system")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSales() {
        try {
            List<Sale> sales = saleService.getSales();
            if (sales.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(sales);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting sales");
        }
    }

    @Operation(summary = "Creating new sale", description = "Allows to create a new sale in the system")
    @PostMapping(value = "/{idClient}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveSale(@PathVariable(name = "idClient") Integer idClient, @RequestBody ProductSale productSale) {
        try {
            Sale savedSale = saleService.createSale(idClient, productSale.getProduct().getIdProduct(), productSale.getQuantity());
            return ResponseEntity.created(URI.create("/api/sales/" + savedSale.getIdSale())).body(savedSale);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during creating sale");
        }
    }

    @Operation(summary = "Getting a specific sale", description = "Allows to get an specific sale by ID in the system")
    @GetMapping(value = "/sale/{idSale}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<?> getSaleById(@PathVariable(name = "idSale") Integer idSale) {
        try {
            Optional<Sale> sale = saleService.findSaleById(idSale);
            if (sale.isPresent()) {
                Sale saleWithTotal = saleService.calculateTotal(sale.get());
                return ResponseEntity.ok(saleWithTotal);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting sale");
        }
    }
}
