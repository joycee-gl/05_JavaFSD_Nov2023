package com.greatlearning.ssrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ssrs.entity.Student;
import com.greatlearning.ssrs.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping("/list")
  public String listStudents(Model theModel) {

    List<Student> students = studentService.findAll();

    theModel.addAttribute("students", students);

    return "list-students";
  }
}  