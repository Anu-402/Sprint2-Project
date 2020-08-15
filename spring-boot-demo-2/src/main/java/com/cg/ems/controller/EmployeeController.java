package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeService  employeeService;
	

	@GetMapping("employee/char/{ch}")
	public ResponseEntity<List<Employee>>  findAllEmployeesByCharacter(@PathVariable("ch") char ch)
	{
	  
		List<Employee> list = employeeService.findAllEmployeeByCharacterName(ch);
		ResponseEntity<List<Employee>>  rt = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	
	@GetMapping("employee")
	public ResponseEntity<List<Employee>>  findAllEmployees()
	{
	  
		List<Employee> list = employeeService.findAllEmployees();
		ResponseEntity<List<Employee>>  rt = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	@GetMapping("employee/{low}/{high}")
	public ResponseEntity<List<Employee>>  findAllEmployeesBySalary(@PathVariable("low") double low,@PathVariable("high") double high)
	{
	  
		List<Employee> list = employeeService.findAllEmployeeBySalary(low, high);
		ResponseEntity<List<Employee>>  rt = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		return rt;
		
	}
	@GetMapping("employee/{id}")
	public  ResponseEntity<Employee>  findEmployeeById(@PathVariable("id") int employeeId) throws  Exception
	{
		
		Employee  employee = employeeService.findEmployeeById(employeeId);
		ResponseEntity<Employee>  rt = null;
		
		if(employee!=null)
		{
			rt= new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	
	
	@DeleteMapping("employee/{id}")
	public  ResponseEntity<Employee>  deleteEmployeeById(@PathVariable("id") int employeeId) throws Exception
	{
		
		Employee  employee = employeeService.findEmployeeById(employeeId);
		ResponseEntity<Employee>  rt = null;
		
		if(employee!=null)
		{
			employee = employeeService.deleteEmployeeById(employeeId);
			rt= new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	@PostMapping("employee")
	public ResponseEntity<Employee>  createEmployee(@RequestBody Employee employee)
	{
		   Employee emp = employeeService.addEmployee(employee);
		   ResponseEntity<Employee> rt= new ResponseEntity<Employee>(employee,HttpStatus.OK);
		   return rt;
	}
	
}