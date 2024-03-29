package com.TestSpring.repository;

import com.TestSpring.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

  List<Customer> findByFirstName(String FirstName);
  List<Customer> findAll();
}
