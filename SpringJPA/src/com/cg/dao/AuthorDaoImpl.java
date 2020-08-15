package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Author;

public class AuthorDaoImpl implements AuthorDao{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager manager = factory.createEntityManager();
	@Override
	public boolean addAuthor(Author author) {	
		manager.getTransaction().begin();
		manager.persist(author);
		manager.getTransaction().commit();
		
		return true;
	}

	@Override
	public boolean deleteAuthor(Author author) {
		Author temp =manager.find(Author.class, author.getAuthorId());
		System.out.println(temp);
		if(author.equals(temp)) {
		manager.getTransaction().begin();
		manager.remove(author);
		manager.getTransaction().commit();
		return true;
		}
		else
		return false;
		
		
	}

	@Override
	public Author updateAuthor(Author author) {
		manager.getTransaction().begin();
		Author temp =manager.merge(author);
		manager.getTransaction().commit();
		System.out.println(" dao "+temp);
		return temp;
	}

	@Override
	public Author findAuthor(Integer id) {
		
		return manager.find(Author.class, id);
	}
	
	

}
