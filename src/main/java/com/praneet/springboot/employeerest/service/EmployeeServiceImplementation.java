package com.praneet.springboot.employeerest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		
		List<EmployeeEntity> employeesList=employeeDao.getAllEmployees();
		return employeesList;
	}

	@Override
	@Transactional
	public EmployeeEntity getEmployee(int id) {
		
		EmployeeEntity employee=employeeDao.getEmployee(id);
		return employee;
	}

	@Override
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDao.addEmployee(employee);
		
	}

}
