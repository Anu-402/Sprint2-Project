package com.cg.dao;

import com.cg.bean.Author;

public interface AuthorDao {
	
	public boolean addAuthor(Author author);
	public boolean deleteAuthor(Author author);
	public Author updateAuthor(Author author);
	public Author findAuthor(Integer id);

}
