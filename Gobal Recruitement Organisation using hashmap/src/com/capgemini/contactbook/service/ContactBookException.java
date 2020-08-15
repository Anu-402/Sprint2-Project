package com.capgemini.contactbook.service;

public class ContactBookException extends Exception {
	public ContactBookException(String msg) {
		System.out.println("\nERROR:"+msg+"\n");
	}

}
