package com.revature.spark.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spark.beans.Customer;
import com.revature.spark.beans.Flight;
import com.revature.spark.repository.FlightRepository;
import com.revature.spark.repository.CustomerRepository;
import com.revature.spark.todo.AssociateImplementation;

@Service
public class FlightService {

	/**
	 * In Spring, we would likely @Autowired this property. Just to keep the
	 * associate code free of Spring annotations, we opted to simply instantiate the
	 * old-fashioned way.
	 */
	private AssociateImplementation associateImplementation = new AssociateImplementation();

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	public Flight create(Flight flight) {
		validateCustomer(flight);
		Optional<Flight> toSave = flightRepository.findById(flight.getFlightNumber());
		if (toSave.isPresent()) {
			throw new RuntimeException("The record with identifier " + flight.getFlightNumber()
					+ " already exists. Please select a unique identifier.");
		} else {
			return flightRepository.save(flight);
		}
	}

	public Flight update(Flight flight) {
		validateCustomer(flight);
		Optional<Flight> toUpdate = flightRepository.findById(flight.getFlightNumber());
		if (toUpdate.isPresent()) {
			Flight update = toUpdate.get();
			update.setTicketPrice(flight.getTicketPrice());
			update.setDepartsFrom(flight.getDepartsFrom());
			update.setDestination(flight.getDestination());
			update.setCustomer(flight.getCustomer());
			return flightRepository.save(update);
		} else {
			throw new RuntimeException("The record with identifier " + flight.getFlightNumber()
					+ " was not found. You cannot update a record that does not exist.");
		}
	}

	private void validateCustomer(Flight flight) {
		Optional<Customer> customer = customerRepository.findById(flight.getCustomer().getId());
		if (!customer.isPresent()) {
			throw new RuntimeException("Customer record does not exist.");
		}
	}

	public void delete(Flight flight) {
		flightRepository.delete(flight);
	}

	public Double sum() {
		return associateImplementation.sum(flightRepository.findAll());
	}

	public Double min() {
		return associateImplementation.min(flightRepository.findAll());
	}

	public Double max() {
		return associateImplementation.max(flightRepository.findAll());
	}

	public Double avg() {
		return associateImplementation.avg(flightRepository.findAll());
	}

	public Double median() {
		return associateImplementation.median(flightRepository.findAll());
	}

}
