package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.RentalStatus;

import java.time.LocalDate;

public class RentalDto {

    CarDto car;
    LocalDate startDate;
    LocalDate endDate;
    RentalStatus status;

    public RentalDto(CarDto car, LocalDate startDate, LocalDate endDate, RentalStatus status) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public CarDto getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public RentalStatus getStatus() {
        return status;
    }
}
