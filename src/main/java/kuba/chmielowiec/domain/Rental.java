package kuba.chmielowiec.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Client_Id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "Car_Number")
    Car car;

    LocalDate startDate;
    LocalDate endDate;

    @Enumerated(EnumType.STRING)
    RentalStatus status;

    Rental(){}

    public Rental(Client client, Car car, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = RentalStatus.ACTIVE;
    }

    public void finish() {
        this.status = RentalStatus.FINISHED;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
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
