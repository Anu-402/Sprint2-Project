package com.capgemini.contactbook.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;

public class ContactBookServiceImpl implements ContactBookService {
static int r;
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		ContactBookDaoImpl cbd =new ContactBookDaoImpl(); 
		if(isValidEnquiry(enqry)) {
			
		
			
			try {
				r=cbd.addEnquiry(enqry);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return r;
	}
		else {
			return 0;
		}
	}
	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException, SQLException {
		// TODO Auto-generated method stub
		ContactBookDaoImpl cbd=new ContactBookDaoImpl();
		EnquiryBean eb = cbd.getEnquiryDetails(EnquiryID);
		return eb;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException {
		
		validateContactNo(enqry.getContactNumber());
		validateFirstName(enqry.getFirstName());
		validateLastName(enqry.getLastName());
		validateLastName(enqry.getPreferredDomain());
		validateLastName(enqry.getPreferredLocation());
		return true;
		
	}
	public void validateFirstName(String firstName) throws ContactBookException {
		Pattern p=Pattern.compile("[a-zA-Z]+");
		Matcher m=p.matcher(firstName);
		if(!m.matches()) {
			throw new ContactBookException("First Name Should Contain Only Alphabets");
		}
	}
		public void validateLastName(String lastName) throws ContactBookException {
			Pattern p=Pattern.compile("[a-zA-Z]+");
			Matcher m=p.matcher(lastName);
			if(!m.matches()) {
				throw new ContactBookException("last Name Should Contain Only Alphabets");
			}
		}
			public void validatePreferredDomain(String preferredDomain) throws ContactBookException {
				Pattern p=Pattern.compile("[a-zA-Z]+");
				Matcher m=p.matcher(preferredDomain);
				if(!m.matches()) {
					throw new ContactBookException("Domain Should Contain Only Alphabets");
				}
			}
				public void validatePreferredLocation(String preferredLocation) throws ContactBookException {
					Pattern p=Pattern.compile("[a-zA-Z]+");
					Matcher m=p.matcher(preferredLocation);
					if(!m.matches()) {
						throw new ContactBookException("Location Should Contain Only Alphabets");
					}
	}
	public void validateContactNo(String contactNumber) throws ContactBookException{
		if(!(contactNumber.length()==10)) {
			throw new ContactBookException("Invalid Mobile Number:");
		}
		
	}

	

}
