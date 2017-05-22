package kuba.chmielowiec.domain.client;

import kuba.chmielowiec.domain.commands.CreateClientCommand;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    @Embedded
    private Address address;

    Client(){}

    public Client(CreateClientCommand cmd) {
        this.firstName = cmd.getFirstName();
        this.lastName = cmd.getLastName();
        this.pesel = cmd.getPesel();
        this.address = cmd.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public Address getAddress() {
        return address;
    }
}
