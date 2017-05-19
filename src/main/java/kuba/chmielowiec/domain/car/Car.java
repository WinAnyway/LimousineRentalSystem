package kuba.chmielowiec.domain.car;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.Year;
import java.time.format.DateTimeFormatter;

@Entity
public class Car {

    @EmbeddedId
    private RegistrationNumber registrationNumber;
    private String brand;
    private String model;
    private Year year;
    private boolean available;

    Car(){}

    public Car(CreateCarCommand cmd) {
        this.registrationNumber = new RegistrationNumber(cmd.getRegistrationNumber());
        this.brand = cmd.getBrand();
        this.model = cmd.getModel();
        this.year = Year.parse(cmd.getYear(), DateTimeFormatter.ofPattern("yyyy"));
        this.available = true;
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

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        this.available = false;
    }
}
