package com.capg.hcms.test_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.test_management.exception.TestException;
import com.capg.hcms.test_management.model.TestManagement;
import com.capg.hcms.test_management.service.TestManagementService;

@RestController
@CrossOrigin("*")
public class TestManagementController {

	@Autowired
	TestManagementService  testService;

	@GetMapping("test")
	public ResponseEntity<List<TestManagement>>  findAllTests() throws TestException
	{
	  
		List<TestManagement> list=testService.findAllTests();
		ResponseEntity<List<TestManagement>>  rt = new ResponseEntity<List<TestManagement>>(list,HttpStatus.OK);
		return rt;
		
	}	
	@PostMapping("test")
	public ResponseEntity<TestManagement>  addTest(@RequestBody TestManagement test)
	{
		TestManagement te=testService.addTest(test);
		ResponseEntity<TestManagement>  re = new ResponseEntity<TestManagement>(te,HttpStatus.OK);
		return re;
	}
	
	
	
	@DeleteMapping("test/{id}")
	public  ResponseEntity<TestManagement>  deleteTestById(@PathVariable("id") int testId) throws TestException
	{
		
		ResponseEntity<TestManagement>  rt = null;
	    TestManagement test = testService.deleteTestById(testId);
		rt= new ResponseEntity<TestManagement>(test,HttpStatus.OK);
		return rt;
	}
	@GetMapping("test/{id}")
	public  ResponseEntity<TestManagement>  findTestById(@PathVariable("id")  int id) throws TestException 
	{
		
		   TestManagement  test = testService.findTestById(id);
		   ResponseEntity<TestManagement>  re = new ResponseEntity<TestManagement>(test,HttpStatus.OK);
		   return re;
	}
	
	
	@PutMapping("test")
	public ResponseEntity<TestManagement> updateTest(@RequestBody TestManagement test) throws TestException
	{
		ResponseEntity<TestManagement> rt =null;
		if(test!=null)
		{
		test=testService.updateTest(test);
		rt=new ResponseEntity<TestManagement>(test,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<TestManagement>(test,HttpStatus.NOT_FOUND);
		}
		return rt;
	}
}