package com.bumblebee.system.service;

import com.bumblebee.system.model.Customers;

import com.bumblebee.system.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customers createCustomer(Customers customers){
        
        return customerRepository.save(customers);
    }
    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }
    public Customers getCustomersById(Long id){
        return customerRepository.findById(id).get();
    }

    public Customers updateCustomers(Customers customers){
        return customerRepository.save(customers);
    }
    public void deleteCustomers(Long id){
        customerRepository.deleteById(id);
    }
}
