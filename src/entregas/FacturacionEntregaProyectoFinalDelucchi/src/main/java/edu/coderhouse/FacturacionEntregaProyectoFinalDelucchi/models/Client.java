package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private int idClient;

    @Column(name = "FIRST_NAME")
    private String firtsName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DNI")
    private int dni;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @Column(name = "PURCHASES")
    private List<Sale> purchases;

    public Client() {
    }

    public Client(String firtsName, String lastName, int dni) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.dni = dni;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Sale> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Sale> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient && dni == client.dni && Objects.equals(firtsName, client.firtsName) && Objects.equals(lastName, client.lastName) && Objects.equals(purchases, client.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firtsName, lastName, dni, purchases);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firtsName='" + firtsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", purchases=" + purchases +
                '}';
    }
}
