package com.Employee.EmployeeAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.EmployeeAPI.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
