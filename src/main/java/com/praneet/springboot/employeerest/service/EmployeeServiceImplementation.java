package com.praneet.springboot.employeerest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneet.springboot.employeerest.dataaccessobject.EmployeeDao;
import com.praneet.springboot.employeerest.entity.EmployeeEntity;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImplementation(EmployeeDao theEmployeeDao) {
		this.employeeDao=theEmployeeDao;
	}
	
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		List<EmployeeEntity> employeesList=employeeDao.getEmployees();
		return employeesList;
	}

}
