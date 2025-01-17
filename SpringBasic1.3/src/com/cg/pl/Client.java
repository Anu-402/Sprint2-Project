package com.cg.pl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Employee;
import com.cg.bean.SBU;

public class Client {
public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	SBU sbu=ctx.getBean("sbu",SBU.class);
	System.out.println("SBU Details");
	System.out.println("----------------------------");
	System.out.println("sbuCode="+sbu.getSbuCode()+", sbuHead="+sbu.getSbuHead()+", sbuName="+sbu.getSbuName());
	System.out.println("Employee Details:----------------");
	System.out.print("[");
	List<Employee> emp=sbu.getEmplist();
	for(Employee data:emp){
		System.out.print("Employee [");
		System.out.print("empId="+data.getEmployeeId()+", ");
		System.out.print("empName="+data.getEmployeeName()+", ");
		System.out.print("empSalary="+data.getSalary()+"]");
		if(emp.indexOf(data)!=emp.size()-1){
			System.out.print(",");
		}
	}
	System.out.print("]");
}
}
