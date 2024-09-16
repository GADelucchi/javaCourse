package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Product;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProducts() {
        try {
            List<Product> products = productService.getProducts();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(products);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting clients");
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.created(URI.create("/api/products/" + savedProduct.getIdProduct())).body(savedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during creating product");
        }
    }

    @GetMapping(value = "/product/{idProduct}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductById(@PathVariable(name = "idProduct") Integer idProduct) {
        try {
            Optional<Product> product = productService.findProductById(idProduct);
            if (product.isPresent()) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting product");
        }
    }

    @DeleteMapping(value = "/product/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "idProduct") Integer idProduct) {
        try {
            productService.deleteProductById(idProduct);
            return ResponseEntity.ok("Product deleted");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during deleting product");
        }
    }
}
