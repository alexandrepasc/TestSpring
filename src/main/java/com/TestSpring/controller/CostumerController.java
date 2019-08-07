package com.TestSpring.controller;

import com.TestSpring.model.Customer;
import com.TestSpring.repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CostumerController {

  @Autowired
  CustomerRepo repository;

  public String bulkcreate() {

    // save a single Customer
    repository.save(new Customer("Rajesh", "Bhojwani"));

    // save a list of Customers
    repository.saveAll(Arrays.asList(new Customer("Salim", "Khan"), new Customer("Rajesh", "Parihar"),
        new Customer("Rahul", "Dravid"), new Customer("Dharmendra", "Bhojwani")));

    return "Customers are created";
  }

}
