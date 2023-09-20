package com.Employee.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min=5 ,max=10,message="There should be atleast 3-10 characters in name")
	private String name;
	
	@NotNull
	@Min(5000) @Max(100000)
	private float salary;
	
	@NotNull
	@Min(18) @Max(50)
	private int age;
	
	@NotNull
	@Size(min=5 ,max=15,message="There should be atleast 3-15 characters in city")
	private String city;
	
	
	@CreatedDate
	private Instant createdAt;
	
	@LastModifiedDate
	private Instant updtaedAt;

	public Employee() {
	}

	public Employee(int id,
			@NotNull @Size(min = 5, max = 10, message = "There should be atleast 3-10 characters in name") String name,
			@NotNull @Min(5000) @Max(100000) float salary, @NotNull @Min(18) @Max(50) int age,
			@NotNull @Size(min = 5, max = 15, message = "There should be atleast 3-15 characters in city") String city,
			Instant createdAt, Instant updtaedAt) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.city = city;
		this.createdAt = createdAt;
		this.updtaedAt = updtaedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdtaedAt() {
		return updtaedAt;
	}

	public void setUpdtaedAt(Instant updtaedAt) {
		this.updtaedAt = updtaedAt;
	}
	
	

}
