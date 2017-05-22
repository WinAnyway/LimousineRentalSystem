package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.commands.CreateRentalCommand;

public interface RentalProcess {

    String rent(CreateRentalCommand createRentalCommand);

}
