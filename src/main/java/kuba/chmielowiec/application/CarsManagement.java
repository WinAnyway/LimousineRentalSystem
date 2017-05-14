package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.CreateCarCommand;

public interface CarsManagement {
    void create(CreateCarCommand cmd);
}
