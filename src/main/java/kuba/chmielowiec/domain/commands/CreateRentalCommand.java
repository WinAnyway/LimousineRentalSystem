package kuba.chmielowiec.domain.commands;

import kuba.chmielowiec.domain.car.RegistrationNumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreateRentalCommand implements Validatable{

    private Long clientId;
    private String from;
    private String to;
    private RegistrationNumber registrationNumber;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setRegistrationNumber(RegistrationNumber registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public RegistrationNumber getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateFrom(errors);
        validateTo(errors);
        validateRegistrationNumber(errors);
    }

    private void validateRegistrationNumber(ValidationErrors errors) {
        if(isEmpty(registrationNumber.getNumber()))
            errors.add("registrationNumber", "This needs to be filled");
    }

    private void validateTo(ValidationErrors errors) {
        if(isEmpty(to))
            errors.add("firstName", "This field needs to be filled");
        try {
            LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            errors.add("to", "Invalid date format. Correct format is: yyyy/MM/dd");
        }
    }

    private void validateFrom(ValidationErrors errors) {
        if(isEmpty(from))
            errors.add("firstName", "This field needs to be filled");
        try {
            LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            errors.add("from", "Invalid date format. Correct format is: yyyy/MM/dd");
        }
    }
}
