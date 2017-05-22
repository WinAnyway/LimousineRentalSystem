package kuba.chmielowiec.domain.commands;

import kuba.chmielowiec.domain.client.Address;

public class CreateClientCommand implements Validatable {

    private String firstName;
    private String lastName;
    private String pesel;
    private Address address;

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateFirstName(errors);
        validateLastName(errors);
        validatePesel(errors);
        validateAddress(errors);
    }

    private void validatePesel(ValidationErrors errors) {
        if (isEmpty(pesel))
            errors.add("pesel", "This field needs to be filled");
    }

    private void validateLastName(ValidationErrors errors) {
        if (isEmpty(lastName))
            errors.add("lastName", "This field needs to be filled");
    }

    private void validateFirstName(ValidationErrors errors) {
        if (isEmpty(firstName))
            errors.add("firstName", "This field needs to be filled");
    }

    private void validateAddress(ValidationErrors errors) {
        if (address == null)
            errors.add("address", "This field needs to be filled");
        else {
            if (isEmpty(address.getCountry()))
                errors.add("country", "This field needs to be filled");
            if (isEmpty(address.getCity()))
                errors.add("city", "This field needs to be filled");
            if (isEmpty(address.getStreet()))
                errors.add("street", "This field needs to be filled");
            if (isEmpty(address.getPostalCode()))
                errors.add("postalCode", "This field needs to be filled");
        }
    }
}
