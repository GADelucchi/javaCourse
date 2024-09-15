package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services;

import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Sale;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
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
