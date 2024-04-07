package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees details from DB
		List<Employee> employees = employeeService.findAll();
		
		//add to the model
		theModel.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	//step1
	//show form - employee-form.html for saving employee details
	@RequestMapping("/showEmployeeForm_Save")
	public String saveEmployee_Step1(Model theModel) {
		
		//create model attribute
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	//step2
	//save the employee details in DB
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute("employee") Employee employee) {
		
		//save the employee
		employeeService.save(employee);
		
		//redirect to listing page
		return "redirect:/employees/list";
	}
}
