package com.cg.hcs.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hcs.entity.HealthTest;
import com.cg.hcs.entity.Login;
import com.cg.hcs.exception.TestException;
import com.cg.hcs.service.TestService;

@RestController
@CrossOrigin("*")
public class TestController {

	@Autowired
	TestService  testService;

	
	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws TestException
	{
	  
		 Login log = testService.findUser(username,password);
		 if(log==null) {
			 throw new TestException("Login not successful");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
	@GetMapping("test/center/{id}")
	public  ResponseEntity<List<HealthTest>>  findCenterById(@PathVariable("id")  int id) 
	{
		
		   List<HealthTest>  tests = testService.findByCenterId(id);
		   ResponseEntity<List<HealthTest>>  re = new ResponseEntity<>(tests,HttpStatus.OK);
		   return re;
	}
	
	@GetMapping("test/{id}")
	public  ResponseEntity<HealthTest>  findTestById(@PathVariable("id")  int id) throws TestException 
	{
		
		   HealthTest  test = testService.findTestById(id);
		   ResponseEntity<HealthTest>  re = new ResponseEntity<HealthTest>(test,HttpStatus.OK);
		   return re;
	}
	
	@PostMapping("test")
	public ResponseEntity<HealthTest>  addTest(@RequestBody HealthTest test)
	{
		HealthTest te=testService.addTest(test);
		ResponseEntity<HealthTest>  re = new ResponseEntity<HealthTest>(te,HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping("test")
	public ResponseEntity<List<HealthTest>>  findAllTests() throws TestException
	{
	  
		List<HealthTest> list=testService.findAllTests();
		ResponseEntity<List<HealthTest>>  rt = new ResponseEntity<List<HealthTest>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	@DeleteMapping("test/{id}")
	public  ResponseEntity<HealthTest>  deleteTestById(@PathVariable("id") int testId) throws TestException
	{
		
		ResponseEntity<HealthTest>  rt = null;
	    HealthTest test = testService.deleteTestById(testId);
		rt= new ResponseEntity<HealthTest>(test,HttpStatus.OK);
		return rt;
	}
	@PutMapping("test")
	public ResponseEntity<HealthTest> updateTest(@RequestBody HealthTest test) throws TestException
	{
		ResponseEntity<HealthTest> rt =null;
		if(test!=null)
		{
		test=testService.updateTest(test);
		rt=new ResponseEntity<HealthTest>(test,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<HealthTest>(test,HttpStatus.NOT_FOUND);
		}
		return rt;
	}
}