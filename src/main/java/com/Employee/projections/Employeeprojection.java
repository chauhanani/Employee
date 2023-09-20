package com.Employee.projections;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;

public interface Employeeprojection {

	@Value("#{target.id}")
	public int getId();

	@Value("#{target.name}")
	public String getName();

	@Value("#{target.age}")
	public int getAge();

	@Value("#{target.city}")
	public String getCity();

	@Value("#{target.createdAt}")
	public Instant getCreatedAt();

	@Value("#{target.updatedAt}")
	public Instant getUpdtaedAt();

}
