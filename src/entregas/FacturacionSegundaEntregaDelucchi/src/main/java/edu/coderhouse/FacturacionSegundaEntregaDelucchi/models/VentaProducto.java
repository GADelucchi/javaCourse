package edu.coderhouse.FacturacionSegundaEntregaDelucchi.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVentaProducto;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidad;

    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public VentaProducto() {
    }

    public VentaProducto(int idVentaProducto, Venta venta, Producto producto, Integer cantidad) {
        this.idVentaProducto = idVentaProducto;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaProducto that = (VentaProducto) o;
        return idVentaProducto == that.idVentaProducto && Objects.equals(venta, that.venta) && Objects.equals(producto, that.producto) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVentaProducto, venta, producto, cantidad);
    }

    @Override
    public String toString() {
        return "VentaProducto{" +
                "idVentaProducto=" + idVentaProducto +
                ", venta=" + venta +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
