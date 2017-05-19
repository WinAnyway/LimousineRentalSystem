package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.car.CreateCarCommand;

public interface CarsManagement {

    void create(CreateCarCommand cmd);

}
