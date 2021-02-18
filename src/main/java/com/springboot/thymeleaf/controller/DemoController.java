package com.springboot.thymeleaf.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymeleaf.model.Employee;
import com.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class DemoController {

	private EmployeeService employeeService;
	
	@Autowired
	public DemoController(EmployeeService employeeService) {
		
		this.employeeService=employeeService;
	}
	
	@GetMapping("/list")
	public String getEmloyees(Model model){
		
		List<Employee>list=employeeService.findAll();
		model.addAttribute("employees",list);
		return "employee-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showaddform(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee",emp);
		return "add-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.addEmployee(emp);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateform(@RequestParam("employeeId") int id, Model model) {
		Employee emp=employeeService.findbyid(id);
		model.addAttribute("employee",emp);
		return "add-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteEmployee(id);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/search")
	public String getEmloyeesBySearch(@RequestParam("keyword") String keyword,Model model){
		
		if (keyword ==null || keyword.equals("") ) {
			List<Employee>list=employeeService.findAll();
			model.addAttribute("employees",list);
		}else {
			List<Employee> list=employeeService.findByEmailContaining(keyword);
			model.addAttribute("employees",list);
			model.addAttribute("keyword",keyword);
		}
		
		return "employee-form";
	}
}
