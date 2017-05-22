package kuba.chmielowiec;

import kuba.chmielowiec.application.CarsManagement;
import kuba.chmielowiec.application.ClientCatalog;
import kuba.chmielowiec.application.ClientsManagement;
import kuba.chmielowiec.application.RentalProcess;
import kuba.chmielowiec.application.dtos.RentalDto;
import kuba.chmielowiec.application.dtos.RentalHistory;
import kuba.chmielowiec.domain.car.RegistrationNumber;
import kuba.chmielowiec.domain.client.Address;
import kuba.chmielowiec.domain.commands.CreateCarCommand;
import kuba.chmielowiec.domain.commands.CreateClientCommand;
import kuba.chmielowiec.domain.commands.CreateRentalCommand;
import kuba.chmielowiec.domain.commands.InvalidCommandException;
import kuba.chmielowiec.domain.rental.RentalStatus;
import kuba.chmielowiec.infrastructure.NoResourceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RentalProcessTest {

    @Autowired
    RentalProcess rentalProcess;

    @Autowired
    ClientCatalog clientCatalog;

    @Autowired
    CarsManagement carsManagement;

    @Autowired
    ClientsManagement clientsManagement;

    @Autowired
    DbCleaner dbCleaner;

    @Before
    public void setUp() {
        dbCleaner.clean();
        CreateCarCommand carCmd = new CreateCarCommand();
        carCmd.setRegistrationNumber("LU1234");
        carCmd.setBrand("BMW");
        carCmd.setModel("Test");
        carCmd.setYear("2017");
        carsManagement.create(carCmd);
        CreateClientCommand clientCmd = new CreateClientCommand();
        clientCmd.setFirstName("John");
        clientCmd.setLastName("Doe");
        clientCmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "Lipowa", "20-130");
        clientCmd.setAddress(address);
        clientsManagement.create(clientCmd);
    }

    @Test
    public void shouldRentACar() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(1L);
        cmd.setFrom("2017/05/22");
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);

        RentalHistory rentalHistory = clientCatalog.getRentalHistoryOf(1L);
        RentalDto dto = rentalHistory.getRentals().get(0);
        assertEquals(1, rentalHistory.getRentals().size());
        assertEquals(LocalDate.of(2017, 5, 23), dto.getEndDate());
        assertEquals(LocalDate.of(2017, 5, 22), dto.getStartDate());
        assertEquals(RentalStatus.ACTIVE, dto.getStatus());
        assertEquals("LU1234", dto.getCar().getRegistrationNumber());
        assertEquals("BMW", dto.getCar().getBrand());
        assertEquals("Test", dto.getCar().getModel());
        assertEquals("2017", dto.getCar().getYear());
    }

    @Test(expected = NoResourceException.class)
    public void shouldNotRentACarWhichDoesNotExist() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(1L);
        cmd.setFrom("2017/05/22");
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("not exist"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = NoResourceException.class)
    public void shouldNotRentACarWhenClientNotExist() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(500L);
        cmd.setFrom("2017/05/22");
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenFromIsWrong() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(500L);
        cmd.setFrom("wrong");
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenToIsWrong() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(500L);
        cmd.setFrom("2017/05/22");
        cmd.setTo("wrong");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenClientIdIsNull() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setFrom("2017/05/22");
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenFromIsNull() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(1L);
        cmd.setTo("2017/05/23");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenToIsNull() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(1L);
        cmd.setFrom("2017/05/22");
        cmd.setRegistrationNumber(new RegistrationNumber("LU1234"));

        rentalProcess.rent(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotRentACarWhenRegistrationNumberIsNull() {
        CreateRentalCommand cmd = new CreateRentalCommand();
        cmd.setClientId(1L);
        cmd.setFrom("2017/05/22");
        cmd.setTo("2017/05/23");

        rentalProcess.rent(cmd);
    }
}
