package edu.coderhouse.FacturacionSegundaEntregaDelucchi.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VENTAS")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "idVenta"),
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private List<Producto> productos;

    @Column(name = "FECHA")
    private LocalDate fecha = LocalDate.now();

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "Total ")
    private double total;

    public Venta() {
    }

    public Venta(Cliente cliente, List<Producto> productos, int cantidad) {
        this.cliente = cliente;
        this.productos = productos;
        this.cantidad = cantidad;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProducto(List<Producto> productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return total;
    }

    public void setMonto(double monto) {
        this.total = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return idVenta == venta.idVenta && cantidad == venta.cantidad && Double.compare(total, venta.total) == 0 && Objects.equals(fecha, venta.fecha) && Objects.equals(cliente, venta.cliente) && Objects.equals(productos, venta.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, fecha, cliente, productos, cantidad, total);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                '}';
    }
}
