package com.revature.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spark.beans.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{}
