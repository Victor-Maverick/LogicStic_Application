package africa.semicolon.services;

import africa.semicolon.data.model.Customer;
import africa.semicolon.dtos.request.RegisterRequest;
import africa.semicolon.dtos.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    RegisterResponse registerCustomer(RegisterRequest registerRequest);

    Customer findByUsername(String username);
}
