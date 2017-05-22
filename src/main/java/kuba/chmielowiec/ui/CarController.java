package kuba.chmielowiec.ui;

import kuba.chmielowiec.application.*;
import kuba.chmielowiec.application.dtos.CarDto;
import kuba.chmielowiec.domain.commands.CreateCarCommand;
import kuba.chmielowiec.domain.car.RegistrationNumber;
import kuba.chmielowiec.domain.commands.CreateRentalCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarsManagement carsManagement;
    private CarsCatalog carsCatalog;
    private RentalProcess rentalProcess;

    public CarController(CarsManagement carsManagement, CarsCatalog carsCatalog, RentalProcess rentalProcess) {
        this.carsManagement = carsManagement;
        this.carsCatalog = carsCatalog;
        this.rentalProcess = rentalProcess;
    }

    @PutMapping
    public void createCar(@RequestBody CreateCarCommand cmd) {
        carsManagement.create(cmd);
    }

    @GetMapping
    public List<CarDto> showAllCars() {
        return carsCatalog.getAllCars();
    }

    @GetMapping("/{registrationNumber}")
    public CarDto showCar(@PathVariable RegistrationNumber registrationNumber) {
        return carsCatalog.get(registrationNumber);
    }

    @PutMapping("/{registrationNumber}/rent")
    public String rentACar(@PathVariable RegistrationNumber registrationNumber, @RequestBody CreateRentalCommand createRentalCommand) {
         createRentalCommand.setRegistrationNumber(registrationNumber);
        return rentalProcess.rent(createRentalCommand);
    }

}
