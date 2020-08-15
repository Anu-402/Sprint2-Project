package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	   @Autowired
	   EmployeeDao  employeeDao;
	   
	@Override
	public List<Employee> findAllEmployees() {
		
		List<Employee> list = employeeDao.findAll();
		
		return list;
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException
	{
		
		Employee emp = null;
		if( employeeDao.existsById(employeeId))
		{
			emp = employeeDao.findById(employeeId).get();
		}
		else
		{
			throw new EmployeeException(employeeId+ " ID NOT FOUND ");
		}
		return emp;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		employeeDao.saveAndFlush(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int employeeId) {
		
		Employee  emp =null;
		
		if( employeeDao.existsById(employeeId))
		{
			 emp = employeeDao.findById(employeeId).get();
			 employeeDao.deleteById(employeeId);
		}
		return emp ;
	}

	@Override
	public List<Employee> findAllEmployeeBySalary(double low, double high) {
		
		return employeeDao.findAllEmployeeBySalary(low, high);
	}

	@Override
	public List<Employee> findAllEmployeeByCharacterName(char ch) {
		System.out.println(" Character = "+ch);
		return employeeDao.findAllEmployeeByCharacterName(ch);
	}

	
}