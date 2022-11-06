package com.praneet.springboot.employeerest.service;

import java.util.List;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;

public interface EmployeeService {
	
	public List<EmployeeEntity> getAllEmployees();

}
