package africa.semicolon.controllers;

import africa.semicolon.dtos.ApiResponse;
import africa.semicolon.dtos.request.RegisterRequest;
import africa.semicolon.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterRequest request){
        try {
            var response = customerService.registerCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
