package kuba.chmielowiec;

import kuba.chmielowiec.application.CarsCatalog;
import kuba.chmielowiec.application.CarsManagement;
import kuba.chmielowiec.application.dtos.CarDto;
import kuba.chmielowiec.domain.car.RegistrationNumber;
import kuba.chmielowiec.domain.commands.CreateCarCommand;
import kuba.chmielowiec.domain.commands.InvalidCommandException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class CarsManagementTest {

    @Autowired
    CarsManagement carsManagement;

    @Autowired
    CarsCatalog carsCatalog;

    @Test
    public void shouldCreateACar() {
        CreateCarCommand cmd = new CreateCarCommand();
        cmd.setRegistrationNumber("LU1234");
        cmd.setBrand("BMW");
        cmd.setModel("Test");
        cmd.setYear("2017");

        carsManagement.create(cmd);

        CarDto dto = carsCatalog.get(new RegistrationNumber("LU1234"));

        assertNotNull(dto);
        assertEquals("LU1234", dto.getRegistrationNumber());
        assertEquals("BMW", dto.getBrand());
        assertEquals("Test", dto.getModel());
        assertEquals("2017", dto.getYear());
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateACarWhenBrandIsEmpty() {
        CreateCarCommand cmd = new CreateCarCommand();
        cmd.setRegistrationNumber("LU1234");
        cmd.setModel("Test");
        cmd.setYear("2017");

        carsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateACarWhenModelIsEmpty() {
        CreateCarCommand cmd = new CreateCarCommand();
        cmd.setRegistrationNumber("LU1234");
        cmd.setBrand("BMW");
        cmd.setYear("2017");

        carsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateACarWhenYearIsEmpty() {
        CreateCarCommand cmd = new CreateCarCommand();
        cmd.setRegistrationNumber("LU1234");
        cmd.setBrand("BMW");
        cmd.setModel("Test");

        carsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateACarWhenYearIsWrong() {
        CreateCarCommand cmd = new CreateCarCommand();
        cmd.setRegistrationNumber("LU1234");
        cmd.setBrand("BMW");
        cmd.setModel("Test");
        cmd.setYear("Tararara");

        carsManagement.create(cmd);
    }


}
