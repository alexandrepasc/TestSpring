package com.TestSpring.controller;

import com.TestSpring.model.Customer;
import com.TestSpring.repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CostumerController {

  @Autowired
  CustomerRepo repository;

  @GetMapping("/bulkcreate")
  public String bulkcreate() {

    // save a single Customer
    repository.save(new Customer("Rajesh", "Bhojwani"));

    // save a list of Customers
    repository.saveAll(Arrays.asList(
        new Customer("Salim", "Khan"),
        new Customer("Rajesh", "Parihar"),
        new Customer("Rahul", "Dravid"),
        new Customer("Dharmendra", "Bhojwani")));

    return "Customers are created";
  }

  @PostMapping("/create")
  public String create(@RequestBody Customer customer) {
    // save a single Customer
    repository.save(new Customer(customer.getFirstName(), customer.getLastName()));
    return "Customer is created";
  }

  @GetMapping("/findall")
  public List<Customer> findAll() {
    List<Customer> customers = repository.findAll();
//    List<CustomerUI> customerUI = new ArrayList<>();
//    for (Customer customer : customers) {
//      customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
//    }
    return customers;
  }

  @RequestMapping("/search/{id}")
  public Customer search(@PathVariable long id) {
//    String customer = "";
//    customer = repository.findById(id).toString();
    Optional<Customer> customerOptional = repository.findById(id);
    Customer customer = customerOptional.get();
    return customer;
  }

  @RequestMapping("/searchbyfirstname/{firstname}")
  public List<Customer> fetchDataByFirstName(@PathVariable String firstname) {
    List<Customer> customers = repository.findByFirstName(firstname);
    List<Customer> customerUI = new ArrayList<>();
    for (Customer customer : customers) {
      customerUI.add(new Customer(customer.getId(), customer.getFirstName(), customer.getLastName()));
    }
    return customerUI;
  }
}
