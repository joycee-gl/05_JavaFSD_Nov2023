package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
