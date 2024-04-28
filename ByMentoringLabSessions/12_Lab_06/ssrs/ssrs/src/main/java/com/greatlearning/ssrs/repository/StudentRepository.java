package com.greatlearning.ssrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.ssrs.entity.Student;

public interface StudentRepository 
  extends JpaRepository<Student, Integer> {

}          