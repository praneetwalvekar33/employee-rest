package com.praneet.springboot.employeerest.dataaccessobject;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.praneet.springboot.employeerest.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImplementation(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<EmployeeEntity> theQuery=currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class); 
		
		List<EmployeeEntity> employeesList=theQuery.getResultList();

		
		return employeesList;
	}

	@Override
	public void addEmployee(EmployeeEntity employee) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public EmployeeEntity getEmployee(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		EmployeeEntity employee=currentSession.get(EmployeeEntity.class,id);
		
		return employee;
	}
	
	@Override
	public void deleteEmployee(int id) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query queryDelete=currentSession.createQuery("delete from EmployeeEntity where id=:employeeId");
		
		queryDelete.setParameter("employeeId",id);
		
		queryDelete.executeUpdate();
		
	}
	
	
}
