package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hcs.dao.TestDao;
import com.cg.hcs.entity.HealthTest;
import com.cg.hcs.exception.TestException;
import com.cg.hcs.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HealthCareSystemApplicationTests {
	 @Autowired 
	 private TestService testService;
	 @MockBean
	private TestDao testdao;
		
	@Test
	void contextLoads() {
	}
	
	public void HealthTest() throws TestException{
		when(testdao.findAll()).thenReturn(Stream.of(new HealthTest(1179,"Blood group"),new HealthTest(1180,"Blood pressure")).collect(Collectors.toList()));
		assertEquals(2,testService.findAllTests().size());
		}
		
}
