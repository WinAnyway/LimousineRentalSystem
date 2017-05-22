package kuba.chmielowiec;

import kuba.chmielowiec.application.ClientCatalog;
import kuba.chmielowiec.application.ClientsManagement;
import kuba.chmielowiec.application.dtos.ClientDto;
import kuba.chmielowiec.domain.client.Address;
import kuba.chmielowiec.domain.commands.CreateClientCommand;
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
public class ClientsManagementTest {

    @Autowired
    ClientsManagement clientsManagement;

    @Autowired
    ClientCatalog clientCatalog;

    @Test
    public void shouldCreateClient() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);

        ClientDto dto = clientCatalog.get(1L);

        assertNotNull(dto);
        assertEquals((Long)1L, dto.getId());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("12345678", dto.getPesel());
        assertEquals(address, dto.getAddress());
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenFirstNameIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenLastNameIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenPeselIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        Address address = new Address("Poland", "Lublin", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenAddressIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenCountryIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("", "Lublin", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenCityIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "", "Lipowa", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenStreetIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "", "20-130");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldNotCreateClientWhenPostalCodeIsEmpty() {
        CreateClientCommand cmd = new CreateClientCommand();
        cmd.setFirstName("John");
        cmd.setLastName("Doe");
        cmd.setPesel("12345678");
        Address address = new Address("Poland", "Lublin", "Lipowa", "");
        cmd.setAddress(address);

        clientsManagement.create(cmd);
    }
}
