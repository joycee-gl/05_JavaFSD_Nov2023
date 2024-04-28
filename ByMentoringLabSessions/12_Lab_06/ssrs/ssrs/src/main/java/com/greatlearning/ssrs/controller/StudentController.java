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

import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;    

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

	  studentService.saveOrUpdate(id, firstName, lastName, course, country);

	  // use a redirect to 'students-listing'
	  return "redirect:/students/list";
	}  

	@RequestMapping("/displayStudentForm_Update")
	public String updateStudent_Step1(@RequestParam("studentId") int studentId, Model theModel) {

		Student student = studentService.findById(studentId);

		// set 'student' as a model attribute to pre-populate the form
		theModel.addAttribute("student", student);

		// send over to our form
		return "student-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {

	    // delete the student
	    studentService.deleteById(studentId);

	    // redirect to 'students-listing'
	    return "redirect:/students/list";
	}  

	@RequestMapping(value = "/403")
	public ModelAndView handleAccessDeniedError(Principal user) {

	  ModelAndView model = new ModelAndView();

	  if (user != null) {
	    model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
	  } else {
	    model.addObject("msg", "You do not have permission to access this page!");
	  }

	  model.setViewName("authorization-error-403");
	  return model;
	}  
	
}