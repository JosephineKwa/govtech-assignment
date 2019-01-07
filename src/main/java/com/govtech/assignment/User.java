package com.govtech.assignment;

import org.springframework.data.annotation.Id;

import com.opencsv.bean.CsvBindByName;

public class User {

	@Id private String id;

	@CsvBindByName
	private String name;

	@CsvBindByName
	private Double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
