package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void save(Employee employee);
	
	public Employee findById(Integer employeeID);
	
	public void deleteById(Integer employeeId);
}
