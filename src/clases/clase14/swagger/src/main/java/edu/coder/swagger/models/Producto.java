package edu.coder.swagger.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PRODUCTOS")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del producto", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int idProducto;

    @Schema(description = "Nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cable USB-C a Lightning")
    @Column(name = "NOMBRE")
    private String nombre;

    @Schema(description = "Marca del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Baseus")
    @Column(name = "MARCA")
    private String marca;

    @Schema(description = "Descripción del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cable de USB-C a Lightning de 1 metro colo negro con puntas metálicas")
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Schema(description = "Precio del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "17000,00")
    @Column(name = "PRECIO")
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, String marca, String descripcion, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto && Double.compare(precio, producto.precio) == 0 && Objects.equals(nombre, producto.nombre) && Objects.equals(marca, producto.marca) && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, marca, descripcion, precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
