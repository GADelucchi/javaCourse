package entregas.FacturacionPrimeraEntregaDelucchi.src.main.java.edu.coderhouse.FacturacionPrimeraEntregaDelucchi.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "VENTAS")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenta;

    @Column(name = "FECHA")
    private LocalDate fecha = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "MONTO ")
    private double monto = producto.getPrecio() * cantidad;

    public Venta() {
    }

    public Venta(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return idVenta == venta.idVenta && cantidad == venta.cantidad && Double.compare(monto, venta.monto) == 0 && Objects.equals(fecha, venta.fecha) && Objects.equals(cliente, venta.cliente) && Objects.equals(producto, venta.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, fecha, cliente, producto, cantidad, monto);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", monto=" + monto +
                '}';
    }
}
