package com.st.Student.dao;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.st.Student.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public long saveEmployee(Employee employee) {
		return	(Long) sessionFactory.getCurrentSession().save(employee);
		 
	}

	@Transactional
	public Employee getEmployee(long id) {
		return  (Employee) sessionFactory.getCurrentSession().get(Employee.class,id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getAllEmployees() {
	  return sessionFactory.getCurrentSession().createQuery("from users").list();
	}
    
    @Transactional
	public void deleteEmployee(long id) {
    	Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
    	if(null != employee) {
    		this.sessionFactory.getCurrentSession().delete(employee);
    	}
	}

    @Transactional
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
        return employee;
	}
}
