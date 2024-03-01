package com.Employee.EmployeeAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.EmployeeAPI.model.Employee;
import com.Employee.EmployeeAPI.repository.EmployeeRepo;
import com.Employee.EmployeeAPI.serviceIMPL.EmployeeServiceIMPL;

@RestController
@RequestMapping("/empapi")
public class EmployeeController {

	
	@Autowired
	private EmployeeServiceIMPL empservice;
	
	@GetMapping("/home")
	public String homepage() {
		return "Welcome in eployee api";
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp=empservice.addEmployee(employee);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id){
		 empservice.removeEmployee(id);
		return new ResponseEntity<String>("Employee removed Successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
		Optional<Employee> empa= empservice.findEmployeeById(id);
		return new ResponseEntity<Optional<Employee>>(empa,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listOfEmployees(){
		List<Employee> lemp= empservice.getAllEmployee();
		return new ResponseEntity<List<Employee>>(lemp,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateEmp/{id}")
	public ResponseEntity<String> updateEmp(@PathVariable int id){
		empservice.updateEmployee(id);
		
		return new ResponseEntity<String>("Employee updated Successfully",HttpStatus.ACCEPTED);
	}
	
}
