package com.praneet.springboot.employeerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;
import com.praneet.springboot.employeerest.service.EmployeeService;

@RestController
@RequestMapping("/ymnservices")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployees(){
		List<EmployeeEntity> employeesList=employeeService.getAllEmployees();
		
		return employeesList;
	}
}
