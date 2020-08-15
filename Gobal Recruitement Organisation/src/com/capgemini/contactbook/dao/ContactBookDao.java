package com.capgemini.contactbook.dao;

import java.sql.SQLException;

import com.capgemini.contactbook.service.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookDao {

	int addEnquiry(EnquiryBean enqry) throws ContactBookException, ClassNotFoundException, SQLException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException, SQLException;
}
