package com.greatlearning.ssrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ssrs.entity.Student;
import com.greatlearning.ssrs.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;    

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
  
  @RequestMapping("/displayStudentForm")
  public String addStudent_Step1(Model theModel) {

      Student student = new Student();

      theModel.addAttribute("student", student);

      return "student-form";
  }    
  
  @PostMapping("/save")
  public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
      @RequestParam("lastName") String lastName, @RequestParam("course") String course,
      @RequestParam("country") String country) {

    System.out.println("Student ID ->" + id);

    Student studentObj = null;
    if (id == 0) {

      studentObj = new Student(firstName, lastName, course, country);
      System.out.println("Add Student Scenario");
    } else {

      System.out.println("Update Student Scenario");
    }

    // Save/Update the student
    studentService.save(studentObj);

    // use a redirect to 'students-listing'
    return "redirect:/students/list";
  }                  
  
}  