package com.revature.spark.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Flight {

	@Id
	@Column(name="flight_no", nullable=false)
	@Min(value=0)
	private int flightNumber;
	
	@Column(nullable=false)
	@NotBlank
	private String destination;
	
	@Column(name="depart",nullable=false)
	@NotBlank
	private String departsFrom;
	
	@Column(name="ticket_price",nullable=false)
	@Min(value=0)
	private double ticketPrice;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Flight() {
		super();
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartsFrom() {
		return departsFrom;
	}

	public void setDepartsFrom(String departsFrom) {
		this.departsFrom = departsFrom;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((departsFrom == null) ? 0 : departsFrom.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + flightNumber;
		long temp;
		temp = Double.doubleToLongBits(ticketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (departsFrom == null) {
			if (other.departsFrom != null)
				return false;
		} else if (!departsFrom.equals(other.departsFrom))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightNumber != other.flightNumber)
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", destination=" + destination + ", departsFrom=" + departsFrom
				+ ", ticketPrice=" + ticketPrice + ", customer=" + customer + "]";
	}

	public Flight(@Min(0) int flightNumber, @NotBlank String destination, @NotBlank String departsFrom,
			@Min(0) double ticketPrice, Customer customer) {
		super();
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.departsFrom = departsFrom;
		this.ticketPrice = ticketPrice;
		this.customer = customer;
	}
	
}
