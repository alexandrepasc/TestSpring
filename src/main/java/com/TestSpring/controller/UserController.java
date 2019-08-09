package com.TestSpring.controller;

import com.TestSpring.model.User;
import com.TestSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserRepo repository;

  @PostMapping("/register")
  public String register(@RequestBody User user) {
    repository.save(new User(user.getUsername(), user.getPassword()));

    return "register";
  }
}
