package africa.semicolon.services;

import africa.semicolon.data.repository.Customers;
import africa.semicolon.dtos.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    Customers customers;
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testAddCustomer() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("officialbiokesayo@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        registerRequest.setNumber(1);
        registerRequest.setCity("Lagos");
        registerRequest.setState("Lagos");
        customerService.registerCustomer(registerRequest);
        assertEquals(9, customers.count());

    }
}