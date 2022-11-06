package com.praneet.springboot.employeerest.dataaccessobject;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImplementation(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}

	@Override
	@Transactional
	public List<EmployeeEntity> getEmployees() {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<EmployeeEntity> theQuery=currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class); 
		
		List<EmployeeEntity> employeesList=theQuery.getResultList();

		
		return employeesList;
	}
	
	
	
	
}
