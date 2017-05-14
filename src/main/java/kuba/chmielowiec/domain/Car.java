package kuba.chmielowiec.domain;

import javax.persistence.EmbeddedId;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Car {

    @EmbeddedId
    private RegistrationNumber registrationNumber;
    private String brand;
    private String model;
    private Year year;

    public Car(CreateCarCommand cmd) {
        this.registrationNumber = new RegistrationNumber(cmd.getRegistrationNumber());
        this.brand = cmd.getBrand();
        this.model = cmd.getModel();
        this.year = Year.parse(cmd.getYear(), DateTimeFormatter.ofPattern("yyyy"));
    }

    public RegistrationNumber getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }
}
