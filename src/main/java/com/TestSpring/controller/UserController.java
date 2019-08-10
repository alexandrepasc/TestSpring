package com.TestSpring.controller;

import com.TestSpring.model.User;
import com.TestSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

  @Autowired
  UserRepo repository;

  @PostMapping("/register")
  public String register(@RequestBody User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    User newUser = repository.save(new User(user.getUsername(), user.getPassword()));

    return newUser.getId().toString();
  }
}
