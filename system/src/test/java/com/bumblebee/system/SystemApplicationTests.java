package com.bumblebee.system;

import com.bumblebee.system.controller.AuthController;
import com.bumblebee.system.controller.CustomersController;
import com.bumblebee.system.controller.ProductController;
import com.bumblebee.system.payload.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bumblebee.system.model.Product;
import com.bumblebee.system.service.ProductService;

@SpringBootTest
class TestloginAdmin {

@Autowired
AuthController authController;

	@Test
	void Test() {
//		LoginRequest loginRequest=new LoginRequest();
//		loginRequest.setUsername("admin1");
//		loginRequest.setPassword("123456789");
//
//		System.out.println(authController.authenticateUser(loginRequest).getBody());
	}

}
