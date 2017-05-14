package kuba.chmielowiec.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RegistrationNumber implements Serializable{

    private String number;

    public RegistrationNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
