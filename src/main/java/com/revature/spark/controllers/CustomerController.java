package com.revature.spark.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spark.beans.Customer;
import com.revature.spark.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/all")
	public ResponseEntity<List<Customer>> findAll(){
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/customer/all/totalsales")
	public ResponseEntity<Map<Customer, Double>> totalSalesPerCustomer(){
		return new ResponseEntity<>(customerService.totalSalesPerCustomer(), HttpStatus.OK);
	}

}
