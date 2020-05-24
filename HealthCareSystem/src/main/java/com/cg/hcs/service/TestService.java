package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.entity.HealthTest;
import com.cg.hcs.entity.Login;
import com.cg.hcs.exception.TestException;

public interface TestService {
	
	public Login findUser(String username , String password) throws TestException;

	public HealthTest addTest(HealthTest test);
	
	public HealthTest deleteTestById(int testId) throws TestException;
	
	public List<HealthTest>  findAllTests() throws TestException;
	
	public HealthTest findTestById(int testId) throws TestException ;
	
	public List<HealthTest>  findByCenterId(int centerId);
	
	public HealthTest updateTest(HealthTest test)throws TestException ;
	
	
}
