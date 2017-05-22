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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!country.equals(address.country)) return false;
        if (!city.equals(address.city)) return false;
        if (!street.equals(address.street)) return false;
        return postalCode.equals(address.postalCode);

    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + postalCode.hashCode();
        return result;
    }
}
