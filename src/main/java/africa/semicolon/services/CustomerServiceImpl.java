package africa.semicolon.services;

import africa.semicolon.data.model.Address;
import africa.semicolon.data.model.Customer;
import africa.semicolon.data.repository.Customers;
import africa.semicolon.dtos.request.RegisterRequest;
import africa.semicolon.dtos.response.RegisterResponse;
import africa.semicolon.utils.MailsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    MailsSender emailSender;
    @Autowired
    Customers customers;

    @Override
    public RegisterResponse registerCustomer(RegisterRequest registerRequest) {
        Customer customer = new Customer();
        customer.setEmailAddress(registerRequest.getEmail());
        Address address = new Address();
        address.setStreet(registerRequest.getStreet());
        address.setCity(registerRequest.getCity());
        address.setState(registerRequest.getState());
        customer.setAddress(address);
        customers.save(customer);
        RegisterResponse response = new RegisterResponse();
        response.setId(customer.getId());
        response.setPhoneNumber(customer.getPhoneNumber());
        response.setMessage("success");
        emailSender.sendMail(registerRequest);
        return response;
    }

    @Override
    public Customer findByUsername(String username) {
        return customers.findByEmailAddress(username);
    }
}
