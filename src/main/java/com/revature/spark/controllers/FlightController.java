package com.revature.spark.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spark.beans.Flight;
import com.revature.spark.services.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService service;
	
	@GetMapping("/flight/all")
	public ResponseEntity<List<Flight>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping("/flight")
	public ResponseEntity<Flight> create(@Valid @RequestBody Flight flight){
		return new ResponseEntity<>(service.create(flight), HttpStatus.CREATED);
	}

	@PutMapping("/flight")
	public ResponseEntity<Flight> update(@Valid @RequestBody Flight flight){
		return new ResponseEntity<>(service.update(flight), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/flight")
	public ResponseEntity<Void> delete(@Valid @RequestBody Flight flight){
		service.delete(flight);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/flight/sum")
	public ResponseEntity<Double> sum(){
		return new ResponseEntity<>(service.sum(), HttpStatus.OK);
	}
	
	@GetMapping("/flight/min")
	public ResponseEntity<Double> min(){
		return new ResponseEntity<>(service.min(), HttpStatus.OK);
	}
	
	@GetMapping("/flight/max")
	public ResponseEntity<Double> max(){
		return new ResponseEntity<>(service.max(), HttpStatus.OK);
	}
	
	@GetMapping("/flight/avg")
	public ResponseEntity<Double> avg(){
		return new ResponseEntity<>(service.avg(), HttpStatus.OK);
	}
	
	@GetMapping("/flight/median")
	public ResponseEntity<Double> median(){
		return new ResponseEntity<>(service.median(), HttpStatus.OK);
	}
	
}
