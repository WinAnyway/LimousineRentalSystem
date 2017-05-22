package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.commands.CreateCarCommand;

public interface CarsManagement {

    void create(CreateCarCommand cmd);

}
