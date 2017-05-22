package kuba.chmielowiec.domain.commands;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreateCarCommand implements Validatable {
    private String registrationNumber;
    private String brand;
    private String model;
    private String year;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateRegistrationNumber(errors);
        validateBrand(errors);
        validateModel(errors);
        validateYear(errors);
    }

    private void validateYear(ValidationErrors errors) {
        if (isEmpty(year))
            errors.add("year", "This field needs to be filled");
        else {
            try {
                Year.parse(year, DateTimeFormatter.ofPattern("yyyy"));
            } catch (DateTimeParseException e) {
                errors.add("year", "Invalid year format. Correct format: yyyy");
            }
        }
    }

    private void validateModel(ValidationErrors errors) {
        if (isEmpty(model))
            errors.add("model", "This field needs to be filled");
    }

    private void validateBrand(ValidationErrors errors) {
        if (isEmpty(brand))
            errors.add("brand", "This field needs to be filled");
    }

    private void validateRegistrationNumber(ValidationErrors errors) {
        if (isEmpty(registrationNumber))
            errors.add("registrationNumber", "This field needs to be filled");
    }
}
