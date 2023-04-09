package com.bumblebee.system;

import com.bumblebee.system.controller.AuthController;
import com.bumblebee.system.controller.CustomersController;
import com.bumblebee.system.controller.ProductController;
import com.bumblebee.system.payload.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bumblebee.system.model.Customers;
import com.bumblebee.system.model.Product;
import com.bumblebee.system.service.CustomerService;
import com.bumblebee.system.service.ProductService;

@SpringBootTest
class TestloginAdmin {


@Autowired
CustomerService customerService;

	@Test
	void Test() {
Customers customers=new Customers();
customers.setEmail("testemail@gmail.com");
customers.setPassword("1234");
customerService.createCustomer(customers);
	}

}
