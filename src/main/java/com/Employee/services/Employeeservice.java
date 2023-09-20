package com.Employee.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Employee.models.Employee;
import com.Employee.projections.Employeeprojection;
import com.Employee.repository.Employeerepository;
import com.Employee.wrappers.Employeewrapper;

@Service
public class Employeeservice {

	@Autowired
	Employeerepository employeerepository;

	public ResponseEntity<?> addEmployee(Employee employee) {
		employeerepository.save(employee);
		Employeewrapper empwrap = new Employeewrapper();
		empwrap.setMessage("Employee addded successfully");
		empwrap.setData(employeerepository.save(employee));
		return new ResponseEntity<>(empwrap, HttpStatus.OK);
	}

	public ResponseEntity<?> getallEmployee() {
		Iterable<Employee> data = employeerepository.findAll();
		Iterator<Employee> allEmployee = data.iterator();
		if (allEmployee.hasNext()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no Employee in your Company!");
		} else {
			Employeewrapper empwrap = new Employeewrapper();
			empwrap.setMessage("List of all Employees in your Company");
			empwrap.setData(data);
			return new ResponseEntity<>(empwrap, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<?> getEmployeeById(int id) {
//		Employee data = employeerepository.findById(id).orElseThrow(() -> {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//					"There are no Employee with the id: " + id + " in the Company!");
//		});
		Employeeprojection data = employeerepository.findProjectedById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"There are no Employee with the id: " + id + " in the Company!");
		});
		Employeewrapper empwrap = new Employeewrapper();
		empwrap.setMessage("The Employee for the given id: \"+id");
		empwrap.setData(data);
		return new ResponseEntity<>(empwrap, HttpStatus.FOUND);
	}

	public ResponseEntity<?> getEmployeeByName(String name) {
		Employee data = employeerepository.findByName(name).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"There are no Employee with the name: " + name + " in the Company!");
		});
		Employeewrapper empwrap = new Employeewrapper();
		empwrap.setMessage("The Employee for the given name: \"+name");
		empwrap.setData(data);
		return new ResponseEntity<>(empwrap, HttpStatus.FOUND);
	}

	public ResponseEntity<?> updateEmployeeById(int id, Employee employee) {
		Employee found_employee = employeerepository.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"There are no Employee with the id: " + id + " in the Company!");
		});

		employee.setId(id);
		employee.setCreatedAt(found_employee.getCreatedAt());

		Employee updatedById = employeerepository.save(employee);

		Employeewrapper empwrap = new Employeewrapper();
		empwrap.setMessage("Employee with id: " + id + " updated successfully");
		empwrap.setData(updatedById);
		return new ResponseEntity<>(empwrap, HttpStatus.OK);
	}

	public String deleteEmployeeById(int id) {
		getEmployeeById(id);
		employeerepository.deleteById(id);
		return "employee with id:" + id + " removed successfully";

	}

}
