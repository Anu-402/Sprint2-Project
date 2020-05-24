package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.LoginDao;
import com.cg.hcs.dao.TestDao;
import com.cg.hcs.entity.HealthTest;
import com.cg.hcs.entity.Login;
import com.cg.hcs.exception.TestException;
@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao testDao;
	@Autowired
	LoginDao loginDao;

	@Override
	public Login findUser(String username,String password) throws TestException {

		return loginDao.findUser(username,password);
	}
	@Override
	public HealthTest addTest(HealthTest test) {
		HealthTest  ts = testDao.saveAndFlush(test);
	     return ts;
	}

	@Override
	public HealthTest deleteTestById(int testId) throws TestException {
       HealthTest ts =null;
		if( testDao.existsById(testId))
		{
			 ts = testDao.findById(testId).get();
			 testDao.deleteById(testId);
		}
		else
		{
			throw new TestException(" ID NOT FOUND ");
		}
		return ts;
	}

	@Override
	public List<HealthTest> findAllTests() throws TestException {
		List<HealthTest> list = testDao.findAll();
		return list;
	}

	@Override
	public HealthTest findTestById(int testId) throws TestException {
		if( ! testDao.existsById(testId))
		{
			throw new TestException(" ID NOT FOUND ");
		}
		return testDao.findById(testId).get();
	}

	@Override
	public List<HealthTest> findByCenterId(int centerId) {
		return testDao.findByCenterId(centerId);
	}

	@Override
	public HealthTest updateTest(HealthTest test) throws TestException {
		int testId =test.getTestId();
		if(testDao.existsById(testId))
		{
			HealthTest t=testDao.findById(testId).get();
			testDao.saveAndFlush(test);
		}
		else
		{
		throw new TestException("ID NOT FOUND");
		}
		return test;
	}

	
}
