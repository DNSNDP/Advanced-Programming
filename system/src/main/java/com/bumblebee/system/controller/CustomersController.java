package com.bumblebee.system.controller;

import com.bumblebee.system.model.Customers;
import com.bumblebee.system.model.Product;
import com.bumblebee.system.payload.response.MessageResponse;
import com.bumblebee.system.repository.CustomerRepository;
import com.bumblebee.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
public class CustomersController {
    @Autowired
    CustomerService customerService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    CustomerRepository customerRepository;
    @PostMapping(path = "/addCustomer")
    public ResponseEntity<MessageResponse> createCustomers(@RequestBody Customers customers) {

        if (customerRepository.existsByEmail(customers.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email Exists!"));
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            String encrypt=bCryptPasswordEncoder.encode(customers.getPassword());
            customers.setPassword(encrypt);
            customerService.createCustomer(customers);
        }

        return null;
    }
    @GetMapping(path = "/getCustomers")
    public List<Customers> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping(path = "/getCustomers/{id}")
    public Customers getCustomersById(@PathVariable Long id){
        return customerService.getCustomersById(id);
    }
    @DeleteMapping(path="deleteCustomers/{id}")
    public void deleteCustomers(@PathVariable Long id){
        customerService.deleteCustomers(id);
    }

}
