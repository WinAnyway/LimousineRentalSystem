package kuba.chmielowiec.application;

import java.util.List;

public class RentalHistory {

    private Long clientId;
    private List<RentalDto> rentals;

    public RentalHistory(Long clientId, List<RentalDto> rentals) {
        this.clientId = clientId;
        this.rentals = rentals;
    }

    public Long getClientId() {
        return clientId;
    }

    public List<RentalDto> getRentals() {
        return rentals;
    }
}
