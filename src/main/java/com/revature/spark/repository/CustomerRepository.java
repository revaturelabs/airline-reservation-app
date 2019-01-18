package com.revature.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spark.beans.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{}
