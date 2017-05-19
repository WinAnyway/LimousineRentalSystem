package kuba.chmielowiec.application.dtos;

import java.time.Year;

public class CarDto {

    private String registrationNumber;
    private String brand;
    private String model;
    private String year;

    public CarDto(String registrationNumber, String brand, String model, Year year) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.year = String.valueOf(year);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }
}
