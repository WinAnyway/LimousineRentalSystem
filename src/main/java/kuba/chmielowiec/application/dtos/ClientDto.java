package kuba.chmielowiec.application.dtos;

import kuba.chmielowiec.domain.client.Address;

public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private Address address;

    public ClientDto(Long id, String firstName, String lastName, String pesel, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.address = address;
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
