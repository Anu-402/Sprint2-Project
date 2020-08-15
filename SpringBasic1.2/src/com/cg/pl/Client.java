package com.cg.pl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Employee;

public class Client {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Employee employee=ctx.getBean(Employee.class,"emp");
		employee.getSubDetails();
	}
	
}
