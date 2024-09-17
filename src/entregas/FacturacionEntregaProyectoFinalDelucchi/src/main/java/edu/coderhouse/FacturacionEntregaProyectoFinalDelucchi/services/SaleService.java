package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.*;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductSaleRepository productSaleRepository;

    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    @Transactional
    public Sale createSale(Integer idClient, Integer idProduct, Integer quantity) {
        Client client = clientRepository.findById(idClient).orElseThrow(() -> new RuntimeException("Client not found"));

        Product product = productRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Product not found"));

        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setClient(client);
        sale = saleRepository.save(sale);

        ProductSale productSale = new ProductSale();
        productSale.setSale(sale);
        productSale.setProduct(product);
        productSale.setQuantity(quantity);
        productSaleRepository.save(productSale);

        List<ProductSale> productsSale = new ArrayList<>();
        productsSale.add(productSale);
        sale.setProductSales(productsSale);

        Sale saleWithtotal = calculateTotal(sale);

        return saleRepository.save(saleWithtotal);
    }

    public Optional<Sale> findSaleById(Integer idSale) {
        return saleRepository.findById(idSale);
    }

    public Sale calculateTotal(Sale sale) {
        double total = sale.getProductSales().stream()
                .mapToDouble(ps -> ps.getQuantity() * ps.getProduct().getPrice())
                .sum();
        sale.setTotal(total);
        return sale;
    }
}
