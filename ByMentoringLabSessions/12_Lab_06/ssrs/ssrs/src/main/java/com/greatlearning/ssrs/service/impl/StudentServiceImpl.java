package com.greatlearning.ssrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ssrs.entity.Student;
import com.greatlearning.ssrs.repository.StudentRepository;
import com.greatlearning.ssrs.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {

    List<Student> students = studentRepository.findAll();
    return students;
  }

  @Override
  public void save(Student student) {
      studentRepository.save(student);                    
  }
  
}  