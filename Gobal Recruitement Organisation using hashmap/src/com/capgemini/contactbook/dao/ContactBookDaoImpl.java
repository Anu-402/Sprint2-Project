package com.capgemini.contactbook.dao;

import java.util.HashMap;

import com.capgemini.bean.EnquiryBean;
import com.capgemini.contactbook.service.ContactBookException;
public class ContactBookDaoImpl implements ContactBookDao {
	static HashMap<Integer,EnquiryBean> hm=new HashMap<Integer,EnquiryBean>();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException,
			ClassNotFoundException {
		
		hm.put(enqry.getEnquiryId(),enqry);
		int r=enqry.getEnquiryId();
		System.out.println(hm.containsKey(r));
		//System.out.println(hm.get(r));
		return r;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)
			throws ContactBookException {
			EnquiryBean eb = new EnquiryBean();
			if(hm.containsKey(EnquiryID)){
					eb = hm.get(EnquiryID);
					return eb;
			}
				//System.out.println(eb);
			else{
				return eb;
			}
		}
		
		
	}

		
	

	

	
	

