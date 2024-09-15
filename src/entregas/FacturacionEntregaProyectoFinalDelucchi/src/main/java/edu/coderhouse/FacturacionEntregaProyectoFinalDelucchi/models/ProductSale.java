package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models;

// Imports
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_SALES")

public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCT_SALE")
    private int idProductSale;

    @ManyToOne
    @JoinColumn(name = "ID_SALE")
    @JsonIgnore
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

//    Constructors
    public ProductSale() {
    }

    public ProductSale(int quantity) {
        this.quantity = quantity;
    }

//    Getters and Setters
    public int getIdProductSale() {
        return idProductSale;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    Equal and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSale that = (ProductSale) o;
        return idProductSale == that.idProductSale && quantity == that.quantity && Objects.equals(sale, that.sale) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductSale, sale, product, quantity);
    }

//    toString
    @Override
    public String toString() {
        return "ProductSale{" +
                "idProductSale=" + idProductSale +
                ", sale=" + sale +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
