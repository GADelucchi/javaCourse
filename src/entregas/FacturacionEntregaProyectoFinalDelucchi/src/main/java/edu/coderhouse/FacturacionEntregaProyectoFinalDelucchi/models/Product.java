package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCT")
    private int idProduct;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;

    public Product() {
    }

    public Product(String name, String brand, String description, double price) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, brand, description, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
