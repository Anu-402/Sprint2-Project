package com.capg.hcms.test_management.service;

import java.util.List;

import com.capg.hcms.test_management.exception.TestException;
import com.capg.hcms.test_management.model.TestManagement;
public interface TestManagementService {
	
	public TestManagement addTest(TestManagement test);
	
	public TestManagement deleteTestById(int testId) throws TestException;
	
	public List<TestManagement>  findAllTests() throws TestException;
	
	public TestManagement findTestById(int testId) throws TestException ;
	
	public TestManagement updateTest(TestManagement test)throws TestException ;
	
	
}
