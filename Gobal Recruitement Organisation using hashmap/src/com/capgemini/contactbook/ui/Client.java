package com.capgemini.contactbook.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.bean.EnquiryBean;
import com.capgemini.contactbook.service.ContactBookException;
import com.capgemini.contactbook.service.ContactBookServiceImpl;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
		ContactBookServiceImpl cbs = new ContactBookServiceImpl();
		do {
			System.out.println("**************Global Recruitments*****************");
			System.out.println("Choose an operation");
			System.out.println("1. Enter Enquiry Details");
			System.out.println("2. View Enquiry Details on Id");
			System.out.println("0. Exit");
			System.out.println("****************************");
			System.out.print("Enter your Choice : ");

			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.print("Enter First Name:");
				String firstName = sc.next();
				System.out.print("Enter Last Name:");
				String lastName = sc.next();
				System.out.print("Enter Contact Number:");
				String contactNumber = sc.next();
				System.out.print("Enter Preffered Domain:");
				String preferredDomain = sc.next();
				System.out.print("Enter Preferred Location : ");
				String preferredLocation = sc.next();
				EnquiryBean enqry = new EnquiryBean(firstName, lastName, contactNumber, preferredDomain,
						preferredLocation);
				try {
					int r= cbs.addEnquiry(enqry);
					System.out.println("\nThank you " +firstName+" "+lastName+ " your Unique Id is " +r+ " we will contact you shortly.\n");
				} catch (ContactBookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				break;
			case 2:
				System.out.print("Enter Your Uniqe Id : ");
				int uid=sc.nextInt();
				System.out.println("***********************");
				try {
					EnquiryBean eb = cbs.getEnquiryDetails(uid);
					if(eb.getEnquiryId()==uid){
					System.out.println("Id\tFirstName\tLastName\tContactNumber\tPreferredDomain\tPreferredLocation"); 
					System.out.println(eb.getEnquiryId()+"\t"+eb.getFirstName()+"\t\t"+eb.getLastName()+"\t\t"+eb.getContactNumber()+"\t  "+eb.getPreferredDomain()+"\t\t"+eb.getPreferredLocation());
					System.out.println("************************************************************************************************");
					}else{
						System.out.println("Sorry No details Found...");
					}
				}
					catch(NullPointerException e) {
						System.out.println("Sorry No details Found...");
						e.printStackTrace();
					}
					
				catch (ContactBookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 0:System.out.println("Thank you for Selecting Us");
				break;

			}
		} while (ch != 0);
sc.close();
	}

}
