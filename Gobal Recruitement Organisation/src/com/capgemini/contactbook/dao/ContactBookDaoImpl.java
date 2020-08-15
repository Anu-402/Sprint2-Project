package com.capgemini.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.contactbook.service.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements ContactBookDao {

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = DBConnection.getConnection();
		String query = "insert into ContactBook values(?,?,?,?,?,?)";
		//step1: Get PreparedStatement
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, enqry.getEnquiryId());
		pstmt.setString(2, enqry.getFirstName());
		pstmt.setString(3, enqry.getLastName());
		pstmt.setString(4, enqry.getContactNumber());
		pstmt.setString(5, enqry.getPreferredDomain());
		pstmt.setString(6, enqry.getPreferredLocation());
		int r = pstmt.executeUpdate();
		return r;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException, SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DBConnection.getConnection();
		
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from ContactBook where ENQRYID="+EnquiryID);
		EnquiryBean eb = new EnquiryBean();
		while(rs.next()) {
		eb.setEnquiryId(rs.getInt(1));
		eb.setFirstName(rs.getString(2));
		eb.setLastName(rs.getString(3));
		eb.setContactNumber(rs.getString(4));
		eb.setPreferredDomain(rs.getString(5));
		eb.setPreferredLocation(rs.getString(6));
		}
		return eb;
		}
		
	}

	

	
	

