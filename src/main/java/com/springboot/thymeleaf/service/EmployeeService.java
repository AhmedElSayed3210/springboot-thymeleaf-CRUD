package com.springboot.thymeleaf.service;

import java.util.List;

import com.springboot.thymeleaf.model.Employee;


public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findbyid(int id);
	public void addEmployee(Employee emp);
	public void deleteEmployee(int id);
	public List<Employee> findByEmailContaining(String key);
}
