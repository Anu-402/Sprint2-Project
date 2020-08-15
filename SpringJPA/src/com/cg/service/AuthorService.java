package com.cg.service;

import com.cg.bean.Author;
import com.cg.exception.AuthorException;

public interface AuthorService {
	
	public boolean addAuthor(Author author) throws AuthorException;
	public boolean deleteAuthor(Author author);
	public Author updateAuthor(Author author) throws AuthorException;
	public Author findAuthor(Integer id);
}
