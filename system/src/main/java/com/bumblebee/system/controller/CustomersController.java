package com.bumblebee.system.controller;

import com.bumblebee.system.model.Customers;
import com.bumblebee.system.model.Product;
import com.bumblebee.system.payload.response.MessageResponse;
import com.bumblebee.system.repository.CustomerRepository;
import com.bumblebee.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
  
    @PutMapping(path = "/updateCustomers/{id}")
    public ResponseEntity<?> updateProducts(@RequestBody Customers customers, @PathVariable Long id){
        Optional<Customers> findProduct = Optional.ofNullable(customerService.getCustomersById(id));

        if(findProduct.isPresent()) {
            Customers updateProduct = findProduct.get();
            updateProduct.setBudget(customers.getBudget());
            updateProduct.setName(customers.getName());
            updateProduct.setLoanBalance(customers.getLoanBalance());
            
            return new ResponseEntity<>(customerService.updateCustomers(updateProduct), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
