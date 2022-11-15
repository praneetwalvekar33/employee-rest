package com.praneet.springboot.employeerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneet.springboot.employeerest.ErroHandling.EmployeeNotFoundException;
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
	
	@GetMapping("/employee/{employeeId}")
	public EmployeeEntity getEmployee(@PathVariable int employeeId) {
		EmployeeEntity employee=employeeService.getEmployee(employeeId);
		
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee not found for Id: "+employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) {
		
		employee.setId(0);
		employeeService.addEmployee(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		EmployeeEntity employee=employeeService.getEmployee(employeeId);
		
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee not found for Id: "+ employeeId);
		}
		employeeService.deleteEmployee(employeeId);
		
		return "Successfully deleted employee with ID: "+ employeeId;
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody EmployeeEntity employee) {
		
		employeeService.addEmployee(employee);
		
		return "Successfully added employee for id: " + employee.getId();
	}
}
