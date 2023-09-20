package com.Employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Employee.models.Employee;
import com.Employee.services.Employeeservice;

@RestController
@RequestMapping("/employees")
public class Employeecontroller {

	@Autowired
	Employeeservice employeeservice;
	
	@PostMapping("")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		return employeeservice.addEmployee(employee);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getallEmployee() {
			return employeeservice.getallEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
		return employeeservice.getEmployeeById(id);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable int id,@RequestBody Employee employee) {
		return employeeservice.updateEmployeeById(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return employeeservice.deleteEmployeeById(id);

	}
	
	@GetMapping("/search-by")
	public ResponseEntity<?> getEmployeeByName(String name) {
		return employeeservice.getEmployeeByName(name);
	}
}
