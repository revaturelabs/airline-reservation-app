package com.revature.spark;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.spark.beans.Customer;
import com.revature.spark.beans.Flight;
import com.revature.spark.todo.AssociateImplementation;

public class AssociateImplementationTest {
	
	static AssociateImplementation testObj = new AssociateImplementation();
	static double precision = 0.01; // the "delta" used to measure the precision of the tests
		
	List<Flight> flightListEven;
	List<Flight> flightListOdd;
	Map<Flight, Double> customerTotals;
	
	Customer custA = new Customer(1, "Alpha", "Adams");
	Customer custB = new Customer(2, "Beta", "Belarus");
	Customer custC = new Customer(3, "Charlie", "Cordray");
	
	@BeforeClass
	public void generateData() {
		flightListEven = new ArrayList<>();
		
		// even test case
		flightListEven.add(new Flight(1, "A", "B", 150.55, custA));
		flightListEven.add(new Flight(2, "C", "A", 250.17, custB));
		flightListEven.add(new Flight(3, "D", "B", 110.35, custB));
		flightListEven.add(new Flight(4, "E", "C", 290.99, custC));
		flightListEven.add(new Flight(5, "F", "A", 324.11, custC));
		flightListEven.add(new Flight(6, "F", "D", 89.67, custC));
		
		// odd
		flightListOdd = new ArrayList<>();
		flightListOdd.add(new Flight(7, "G", "A", 450.31, custA));
		flightListOdd.add(new Flight(8, "H", "B", 97.45, custA));
		flightListOdd.add(new Flight(9, "I", "B", 213.90, custA));
		flightListOdd.add(new Flight(10, "J", "C", 314.68, custB));
		flightListOdd.add(new Flight(11, "K", "D", 309.52, custC));
	}
	
	@Test
	public void sumTest(){
		double sum = 1215.84;
		double testSum = testObj.sum(flightListEven);
		assertEquals(sum, testSum, precision);
	}
	
	@Test
	public void minTest(){
		double min = 89.67;
		double testMin = testObj.min(flightListEven);
		assertEquals(min, testMin, precision);
	}
	
	@Test
	public void maxTest(){
		double max = 324.11;
		double testMax = testObj.max(flightListEven);
		assertEquals(max, testMax, precision);
	}
	
	@Test
	public void avgTest(){
		double avg = 202.64;
		double testAvg = testObj.avg(flightListEven);
		assertEquals(avg, testAvg, precision);
	}
	
	@Test
	public void medianTest(){
		double medianEven = 0;
		double medianOdd = 0;
		double testMedianEven = testObj.median(flightListEven);
		assertEquals(medianEven, testMedianEven, precision);
		double testMedianOdd = testObj.median(flightListOdd);
		assertEquals(medianOdd, testMedianOdd, precision);
	}
	
	@Test
	public void totalSalesPerCustomerTest(){
		// using the EVEN list
		Map<Customer, Double> testTotal = testObj.totalSalesPerCustomer(flightListEven);
		assertEquals(400.72, testTotal.get(custA), precision);
		assertEquals(110.35, testTotal.get(custB), precision);
		assertEquals(704.77, testTotal.get(custC), precision);
	}

}
