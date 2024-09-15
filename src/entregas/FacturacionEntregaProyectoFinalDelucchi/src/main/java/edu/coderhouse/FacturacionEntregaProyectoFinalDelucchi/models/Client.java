package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models;

// Imports
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DNI")
    private int dni;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sale> purchases;

//    Constructors
    public Client() {
    }

    public Client(String firstName, String lastName, int dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
    }

//    Getters and Setters
    public int getIdClient() {
        return idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

//    Equal and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient && dni == client.dni && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(purchases, client.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firstName, lastName, dni, purchases);
    }

//    toString
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", purchases=" + purchases +
                '}';
    }
}
