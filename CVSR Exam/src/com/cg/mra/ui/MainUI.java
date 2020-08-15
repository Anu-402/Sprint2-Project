package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.service.AccountServiceImpl;
import com.cg.mra.service.MobileNoException;

public class MainUI {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountDaoImpl adi = new AccountDaoImpl();
		
		AccountServiceImpl asi = new AccountServiceImpl();
		
		while(true){
			System.out.println("1.Account Balance Enquiry\n2.Recharge Account\n3.Exit ");
			System.out.print("Enter Your Chioce : ");
			int choice = sc.nextInt();
		  switch(choice) { 
		  case 1: System.out.print("Enter Mobile Number:"); 
		  String mobileno = sc.next();
		  if(mobileno.length()!=10){
			 try {
				throw new MobileNoException("Invalid Number");
			} catch (MobileNoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  break;
		  }
		  try {
		  Account a = asi.getAccountDetails(mobileno);
		  
		  System.out.println("Account Balence:"+a.getAccountBalance());}
		  catch(Exception e) {
			  System.out.println("ERROR: Number not found");
		  }
		  
		  break; 
		  case 2: System.out.print("Enter Mobile Number : "); 
		  mobileno = sc.next(); 
		  if(mobileno.length()!=10){
			 try {
				throw new MobileNoException("Invalid Number");
			} catch (MobileNoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  break;
		  }
		  System.out.print("Enter Recharge Amount :"); 
		  double amount = sc.nextDouble(); 
          int i=asi.rechargeAccount(mobileno,amount );
          Account a = adi.accountEntry.get(mobileno);
          System.out.println("Your Account Recharged Successfully");
          try {
          System.out.println("Hello "+a.getCustomerName()+" Available balence = "+a.getAccountBalance());
          }catch (Exception e) {
			// TODO: handle exception
        	  System.out.println("Account Not Found");
		}
      
		  break;
		  
		  case 3: 
			  System.exit(0);
		  }
	}
		 
	}
}

