package edu.coder.Preentrega;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private long dni;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Domicilio> domicilio;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public List<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(List<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id_cliente == cliente.id_cliente && dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(domicilio, cliente.domicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cliente, nombre, apellido, dni, domicilio);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", domicilio=" + domicilio +
                '}';
    }
}
