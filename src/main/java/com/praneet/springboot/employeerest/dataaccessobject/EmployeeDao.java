package com.praneet.springboot.employeerest.dataaccessobject;

import java.util.List;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;

public interface EmployeeDao {
	
	public List<EmployeeEntity> getEmployees();

}
