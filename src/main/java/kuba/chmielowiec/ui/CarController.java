package kuba.chmielowiec.ui;

import kuba.chmielowiec.application.CarDto;
import kuba.chmielowiec.application.CarsCatalog;
import kuba.chmielowiec.application.CarsManagement;
import kuba.chmielowiec.domain.CreateCarCommand;
import kuba.chmielowiec.domain.RegistrationNumber;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarsManagement carsManagement;
    private CarsCatalog carsCatalog;

    public CarController(CarsManagement carsManagement, CarsCatalog carsCatalog) {
        this.carsManagement = carsManagement;
        this.carsCatalog = carsCatalog;
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
}
