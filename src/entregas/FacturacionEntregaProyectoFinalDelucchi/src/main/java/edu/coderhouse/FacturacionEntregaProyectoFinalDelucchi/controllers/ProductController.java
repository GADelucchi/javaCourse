package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Product;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Tag(name = "ProductController")

public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Getting all products", description = "Allows to get all products in the system")
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
            return ResponseEntity.internalServerError().body("Error during getting products");
        }
    }

    @Operation(summary = "Creating new product", description = "Allows to create a new product in the system")
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
            return ResponseEntity.internalServerError().body("Error during creating product");
        }
    }

    @Operation(summary = "Getting a specific product", description = "Allows to get an specific product by ID in the system")
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

    @Operation(summary = "Deleting a product", description = "Allows to delete a product by ID in the system")
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
