package com.cg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entity.Employee;
import com.cg.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService  employeeService ;
	
	//@RequestMapping(method=RequestMethod.GET,value="employee")
	  @GetMapping("employee")
	public  List<Employee>  getAllEmployees()
	{
		  return employeeService.findall();
				  
	}
}
