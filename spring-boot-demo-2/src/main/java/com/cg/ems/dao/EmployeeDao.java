package com.cg.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

	@Query("FROM Employee where salary between :low and :high")
	  public List<Employee>  findAllEmployeeBySalary(@Param("low")double low,@Param("high") double high);
	
	
	@Query("From Employee where employeeName like :ch% ")
	  public List<Employee>  findAllEmployeeByCharacterName(@Param("ch") char ch);
	  
	  
	  
	  
}