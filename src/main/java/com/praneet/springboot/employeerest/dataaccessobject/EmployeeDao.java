package com.praneet.springboot.employeerest.dataaccessobject;

import java.util.List;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;

public interface EmployeeDao {
	
	public List<EmployeeEntity> getAllEmployees();
	
	public EmployeeEntity getEmployee(int id);
	
	public void addEmployee(EmployeeEntity employee);
	
	public void deleteEmployee(int id);

}
