package com.greatlearning.ssrs.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.ssrs.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u WHERE u.username = ?1")
  public User getUserByUsername(String username);

}        