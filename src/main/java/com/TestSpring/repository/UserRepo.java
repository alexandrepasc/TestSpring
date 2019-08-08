package com.TestSpring.repository;

import com.TestSpring.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  List<User> findByUsername(String username);
  List<User> findAll();
}
