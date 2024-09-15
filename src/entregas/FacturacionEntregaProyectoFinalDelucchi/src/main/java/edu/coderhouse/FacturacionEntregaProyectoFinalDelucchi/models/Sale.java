package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models;

// Imports
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SALES")

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALE")
    private int idSale;

    @Column(name = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<ProductSale> productSales;

    private double total;

//    Constructors
    public Sale() {
    }

    public Sale(LocalDate date, double total) {
        this.date = date;
        this.total = total;
    }

//    Getters and Setters
    public int getIdSale() {
        return idSale;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductSale> getProductSales() {
        return productSales;
    }

    public void setProductSales(List<ProductSale> productSales) {
        this.productSales = productSales;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    Equal and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return idSale == sale.idSale && Objects.equals(date, sale.date) && Objects.equals(client, sale.client) && Objects.equals(productSales, sale.productSales) && Objects.equals(total, sale.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, date, client, productSales, total);
    }

//    toString
    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", date=" + date +
                ", client=" + client +
                ", productSales=" + productSales +
                ", total=" + total +
                '}';
    }
}
