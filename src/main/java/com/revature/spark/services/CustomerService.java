package com.revature.spark.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spark.beans.Customer;
import com.revature.spark.repository.CustomerRepository;
import com.revature.spark.repository.FlightRepository;
import com.revature.spark.todo.AssociateImplementation;

@Service
public class CustomerService {
	
	/**
	 * In Spring, we would likely @Autowired this property.
	 * Just to keep the associate code free of Spring annotations,
	 * we opted to simply instantiate the old-fashioned way.
	 */
	private AssociateImplementation associateImplementation = new AssociateImplementation();
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public Map<Customer, Double> totalSalesPerCustomer(){
		return associateImplementation.totalSalesPerCustomer(flightRepository.findAll());
	}
	
}
