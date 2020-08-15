package com.capgemini.contactbook.service;

import java.sql.SQLException;

import com.capgemini.bean.EnquiryBean;


public interface ContactBookService {
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException, SQLException;
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException;
	
}