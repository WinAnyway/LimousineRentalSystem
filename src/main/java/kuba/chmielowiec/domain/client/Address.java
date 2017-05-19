package kuba.chmielowiec.domain.client;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String country;
    private String city;
    private String street;
    private String postalCode;

    Address(){}

    public Address(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
