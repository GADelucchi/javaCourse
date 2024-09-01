package edu.coder.Preentrega;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "DOMICILIO")

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_domicilio;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @Column(name = "piso")
    private int piso;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "código postal")
    private String codigoPostal;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "provincia")
    private String provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero, int piso, String departamento, String codigoPostal, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public long getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(long id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return id_domicilio == domicilio.id_domicilio && numero == domicilio.numero && piso == domicilio.piso && Objects.equals(calle, domicilio.calle) && Objects.equals(departamento, domicilio.departamento) && Objects.equals(codigoPostal, domicilio.codigoPostal) && Objects.equals(localidad, domicilio.localidad) && Objects.equals(provincia, domicilio.provincia) && Objects.equals(cliente, domicilio.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_domicilio, calle, numero, piso, departamento, codigoPostal, localidad, provincia, cliente);
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id_domicilio=" + id_domicilio +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
