package com.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeleaf.DAO.EmployeeRepository;
import com.springboot.thymeleaf.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findbyid(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee em=null;
		if (result.isPresent()) {
			em=result.get();
		}
		return em;
	}

	@Override
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
		
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}


	@Override
	public List<Employee> findByEmailContaining(String key) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstNameContaining(key);
	}
	
 
	
}
