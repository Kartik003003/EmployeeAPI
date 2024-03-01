package com.Employee.EmployeeAPI.service;

import java.util.List;
import java.util.Optional;

import com.Employee.EmployeeAPI.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public String removeEmployee(int id);
	
	public Optional<Employee> findEmployeeById(int id);
	
	public List<Employee> getAllEmployee();
	
	public String updateEmployee(int id);
}
