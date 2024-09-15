package edu.coder.swagger.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTES")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del cliente", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int idCliente;

    @Schema(description = "Nombre del cliente", example = "Gastón Alejo", requiredMode = Schema.RequiredMode.REQUIRED, accessMode = Schema.AccessMode.AUTO)
    @Column(name = "NOMBRE")
    private String nombre;

    @Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Delucchi")
    @Column(name = "APELLIDO")
    private String apellido;

    @Schema(description = "Documento de identidad del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "40568729")
    @Column(name = "DNI")
    private long dni;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Schema(description = "Lista de ventas asociadas al cliente", accessMode = Schema.AccessMode.READ_ONLY)
    private List<Venta> compras;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public List<Venta> getCompras() {
        return compras;
    }

    public void setVenta(List<Venta> compras) {
        this.compras = compras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente && dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(compras, cliente.compras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombre, apellido, dni, compras);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", compras=" + compras +
                '}';
    }
}
