package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.EmployeeDao;
import com.cg.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao  employeeDao;
	
	@Override
	public List<Employee> findall() {
		// TODO Auto-generated method stub
		return employeeDao.findall();
	}
}
