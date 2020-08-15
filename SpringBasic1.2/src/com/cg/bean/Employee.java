package com.cg.bean;

public class Employee {
private int employeeId;
private String employeeName;
private double salary;
private int age;
private SBU businessUnit;

public SBU getBusinessUnit() {
	return businessUnit;
}

public void setBusinessUnit(SBU businessUnit) {
	this.businessUnit = businessUnit;
}

public Employee(int employeeId, String employeeName, double salary, int age) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.salary = salary;
	
	this.age = age;
}

public Employee() {
	super();
}

public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public void getSubDetails()
{
	System.out.println("Employee Details");
	System.out.println("-----------------------------------------------------");
	System.out.print("Employee[ Employee Id: "+this.getEmployeeId());
	System.out.print(",Employee Name: "+this.getEmployeeName());
	System.out.print(",Employee Age:"+this.getAge());
	System.out.println();
	System.out.print("SBU Details=SBU [SBUCode= "+this.getBusinessUnit().getSbuId());
	System.out.print(",SBUHead= "+this.getBusinessUnit().getSbuHead());
	System.out.print(",SBUName= "+this.getBusinessUnit().getSbuName());
	System.out.print("]]");
}
}
