package com.springboot.thymeleaf.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.thymeleaf.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

public List<Employee> findByFirstNameContaining(String key);
}
