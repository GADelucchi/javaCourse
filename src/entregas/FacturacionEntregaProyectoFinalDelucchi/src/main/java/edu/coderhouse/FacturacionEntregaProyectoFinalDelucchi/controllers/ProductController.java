package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Product;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.ProductService;
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
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.created(URI.create("/api/products/" + savedProduct.getIdProduct())).body(savedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "/product/{idProduct}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductById(@PathVariable(name = "idProduct") Integer idProduct) {
        Optional<Product> product = productService.findProductById(idProduct);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
