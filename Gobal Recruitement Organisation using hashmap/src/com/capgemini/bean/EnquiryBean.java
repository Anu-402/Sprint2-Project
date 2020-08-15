package com.capgemini.bean;

import java.io.Serializable;
import java.util.Random;

public class EnquiryBean implements Serializable{
	private int enquiryId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String preferredDomain;
	private String preferredLocation;
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPreferredDomain() {
		return preferredDomain;
	}
	public void setPreferredDomain(String preferredDomain) {
		this.preferredDomain = preferredDomain;
	}
	public String getPreferredLocation() {
		return preferredLocation;
	}
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}
	public EnquiryBean( String firstName, String lastName, String contactNumber, String preferredDomain,
			String preferredLocation) {
		super();
		Random r = new Random();
		
		this.enquiryId = r.nextInt(9999);
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.preferredDomain = preferredDomain;
		this.preferredLocation = preferredLocation;
	}
	public EnquiryBean() {
		super();
	}
		
	


}
