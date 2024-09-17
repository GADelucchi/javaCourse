package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Product;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findProductById(Integer idProduct) {
        return productRepository.findById(idProduct);
    }

    @Transactional
    public void deleteProductById(Integer idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        if (product.isPresent()) {
            productRepository.deleteById(idProduct);
        } else {
            throw new NoSuchElementException("Not found product with ID " + idProduct);
        }
    }
}
