package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	public  List<Employee>   findAllEmployees();
	public  Employee   findEmployeeById(int employeeId) throws EmployeeException ;
	public  Employee  addEmployee(Employee employee);
	public  Employee  deleteEmployeeById(int employeeId);
	public List<Employee>  findAllEmployeeBySalary(double low,double high);
	public List<Employee>  findAllEmployeeByCharacterName(char ch);
}