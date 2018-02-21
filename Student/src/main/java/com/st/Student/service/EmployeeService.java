package com.st.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.Student.dao.EmployeeDao;
import com.st.Student.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	

	public long addEmployye(Employee employee) {
		long id =employeeDao.saveEmployee(employee);
		return id;
	}

	public Employee getEmployee(long id) {
		return employeeDao.getEmployee(id);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);	
	}

	public void deleteEmployee(long id) {
		employeeDao.deleteEmployee(id);
	}


}
