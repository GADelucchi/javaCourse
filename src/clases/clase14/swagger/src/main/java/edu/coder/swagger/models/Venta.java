package edu.coder.swagger.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VENTAS")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la venta", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int idVenta;

    @Schema(description = "Datos del cliente que compra", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @Schema(description = "Lista de productos y cantidades", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<VentaProducto> ventaProductos;

    @Schema(description = "Fecha de la venta", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.AUTO, example = "14/09/24")
    @Column(name = "Fecha")
    private LocalDate fecha = LocalDate.now();

    @Schema(description = "Total de la venta", requiredMode = Schema.RequiredMode.REQUIRED, example = "17000,00")
    @Column(name = "Total")
    private double total;

    public Venta() {
    }

    public Venta(Cliente cliente, List<VentaProducto> productos) {
        this.cliente = cliente;
        this.ventaProductos = productos;
    }

    public long getIdVenta() {
        return idVenta;
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

    public List<VentaProducto> getVentaProductos() {
        return ventaProductos;
    }

    public void setVentaProductos(List<VentaProducto> ventaProductos) {
        this.ventaProductos = ventaProductos;
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
        return idVenta == venta.idVenta && Double.compare(total, venta.total) == 0 && Objects.equals(fecha, venta.fecha) && Objects.equals(cliente, venta.cliente) && Objects.equals(ventaProductos, venta.ventaProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, fecha, cliente, ventaProductos, total);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
