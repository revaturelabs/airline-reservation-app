package com.revature.spark.todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.spark.beans.Customer;
import com.revature.spark.beans.Flight;

/**
 * Within this class, you will implement the logic to calculate data for various
 * reports.
 * 
 * @author Your Name Here
 * 
 */
public class AssociateImplementation {

	/**
	 * Find the total ticket sales of all flights.
	 * 
	 * @param flights
	 * @return
	 */
	public Double sum(List<Flight> flights) {
		return 0.0;
	}

	/**
	 * Find the lowest ticker price.
	 * 
	 * @param flights
	 * @return
	 */
	public Double min(List<Flight> flights) {
		return 0.0;
	}

	/**
	 * Find the highest ticket price.
	 * 
	 * @param flights
	 * @return
	 */
	public Double max(List<Flight> flights) {
		return 0.0;
	}

	/**
	 * Find the average ticket price.
	 * 
	 * @param flights
	 * @return
	 */
	public Double avg(List<Flight> flights) {
		return 0.0;
	}

	/**
	 * Find the median ticket price.
	 * 
	 * @param flights
	 * @return
	 */
	public Double median(List<Flight> flights) {
		return 0.0;
	}

	/**
	 * !! BONUS CHALLENGE REQUIREMENT !!
	 * 
	 * Find the total sales for each customer given a list of Flights.
	 * 
	 * Let's look at some example data:
	 * 
	 * Flights 
	 * FlightNo | Destination | Departs | Ticket Price | Customer
	 * 1        | Albuquerque | Austin  |   $150       | A
	 * 2        | Denver      | Seattle |   $210       | B
	 * 3        | Dallas      | Orlando |   $190       | B
	 * 4        | Las Vegas   | Houston |   $300       | C
	 * 5        | Phoenix     | Atlanta |   $340       | A
	 * 6        | Tampa       | New York|   $270       | C
	 * -----------------------------------
	 * Results:
	 * Customer A : $490
	 * Customer B : $400
	 * Customer C : $570
	 * 
	 * @param flights
	 * @return
	 */
	public Map<Customer, Double> totalSalesPerCustomer(List<Flight> flights) {
		return new HashMap<>();
	}

}
