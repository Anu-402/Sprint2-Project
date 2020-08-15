package com.cg.service;

import com.cg.bean.Author;
import com.cg.dao.AuthorDao;
import com.cg.dao.AuthorDaoImpl;
import com.cg.exception.AuthorException;
public class AuthorServiceImpl implements AuthorService{
	
	AuthorDao dao = new AuthorDaoImpl();
	@Override
	public boolean addAuthor(Author author) throws AuthorException {
		String a=author.getFirstName();
		String b =author.getLastName();
		String c=author.getMiddleName();
		String phone = author.getPhoneNo();
		if(!a.matches("[A-Za-z]+"))
			throw new AuthorException("First Name should contain only characters");
		else if(!b.matches("[A-Za-z]+"))
			throw new AuthorException(" Last Name  should contain only characters");
		else if(!c.matches("[A-Za-z]+"))
			throw new AuthorException(" Middle Name  should contain only characters");
		else if(!phone.matches("^[2-9]{2}[0-9]{8}$"))
			throw new AuthorException(" phone number should be 10 digits number");
		else return dao.addAuthor(author);
	}

	@Override
	public boolean deleteAuthor(Author author) {
		return dao.deleteAuthor(author);
	}

	@Override
	public Author updateAuthor(Author author) throws AuthorException {
		String a=author.getFirstName();
		String b =author.getLastName();
		String c=author.getMiddleName();
		String phone = author.getPhoneNo();
		if(!a.matches("[A-Za-z]+"))
			throw new AuthorException("First Name should contain only characters");
		else if(!c.matches("[A-Za-z]+"))
			throw new AuthorException(" Middle Name  should contain only characters");
		else if(!b.matches("[A-Za-z]+"))
			throw new AuthorException(" Last Name  should contain only characters");
		
		else if(!phone.matches("^[2-9]{2}[0-9]{8}$"))
			throw new AuthorException(" phone number should be 10 digits number");
		return dao.updateAuthor(author);
	}

	@Override
	public Author findAuthor(Integer id) {
		return dao.findAuthor(id);
	}

}
