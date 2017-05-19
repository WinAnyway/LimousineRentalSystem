package kuba.chmielowiec.domain.car;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RegistrationNumber implements Serializable{

    private String number;

    RegistrationNumber(){}

    public RegistrationNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
