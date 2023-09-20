package com.Employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Employee.models.Employee;
import com.Employee.projections.Employeeprojection;

public interface Employeerepository extends CrudRepository<Employee, Integer> {
	Optional<Employee> findByName(String name);
	
	
	 Optional<Employeeprojection> findProjectedById(int id);
}
