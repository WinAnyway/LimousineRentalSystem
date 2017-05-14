package kuba.chmielowiec.application;

import java.time.Year;

public class CarDto {

    private final String number;
    private String registrationNumber;
    private String brand;
    private String model;
    private String year;

    public CarDto(String number, String brand, String model, Year year) {
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.year = String.valueOf(year);
    }
}
