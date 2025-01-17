package com.cg.bookStore.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;
import com.cg.bookStore.service.BookStoreService;

@RestController
@RequestMapping("/books")
public class ViewBooksController {
	@Autowired
	public BookStoreService bookservice;
    /* Description : This methods is to view the List of featured Books based on rating from decendinng order from 5 to 1 
     * Return Type : This method will return List of 8 featured Books. 
     * 
     * */
	@CrossOrigin
	@GetMapping("/viewfavoritebooks")
	public List<BookInformation> viewfavoriteBooksByRating(HttpServletRequest request) throws BookException {
		return bookservice.viewfavoriteBooksByRating();
	}
	@CrossOrigin
	@GetMapping("/viewtop4favoritebooks")
	public List<BookInformation> viewtop4favoriteBooksByRating(HttpServletRequest request) throws BookException {
		return bookservice.viewtop4favoriteBooksByRating();
	}
	

	@CrossOrigin
	@GetMapping("/viewallBooks")
	public List<BookInformation> viewAllBooks(HttpServletRequest request) throws BookException {
		return bookservice.viewAllBooksSer();
	}

	
	@CrossOrigin
	@GetMapping("/{bookId}")
	public BookInformation viewBookById(@PathVariable("bookId") int bookId, HttpServletRequest request)  {
		return bookservice.viewBookById(bookId);
	}
	
	@CrossOrigin //View All Categories URL 
	@GetMapping("/category")
	public List<BookCategory> viewAllCategory(HttpServletRequest request) {
		return bookservice.viewBooksCategorys();
	}
	
	@CrossOrigin
	@GetMapping("/category/{categoryId}")
	public List<BookInformation> viewAllBooksByCategory(@PathVariable("categoryId") int categoryId,
			HttpServletRequest request) throws InvalidCategoryIdException {
		return bookservice.viewBooksByCategory(categoryId);
	}
	
	@CrossOrigin
	@GetMapping("/recentlyPublishedBooks")
	public List<BookInformation> recentlyPublishedBooks(HttpServletRequest request) throws  BookException{
		return bookservice.getAllRecentlyPublishedBooks(); 
	}
	
	@CrossOrigin
	@GetMapping("/viewtop4Publishedbooks")
	public List<BookInformation> demorecentlyPublishedBooks(HttpServletRequest request) throws BookException{
		return bookservice.getAll4RecentlyPublishedBooks(); 
	}
	
	@CrossOrigin
	@GetMapping("/getBestSellingBooks")
	public List<BookInformation> getBestSellingBooks (HttpServletRequest request) {
		List<BookInformation> list = bookservice.getBestSellingBooks();
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/get4BestSellingBooks")
	public List<BookInformation> get4BestSellingBooks (HttpServletRequest request) {
		List<BookInformation> list = bookservice.getBestSellingBooks();
		return list;
	}
	@CrossOrigin
	@GetMapping("/viewcustomer/{customerId}")
	public CustomerInformation viewCustomer(HttpServletRequest req, @PathVariable("customerId") String customerId)
			throws CustomerException, CustomerIdNotFoundException {		
		return bookservice.viewCustomer(customerId);

	}
    @CrossOrigin
	@GetMapping("/viewByEmail/{email}")
	public CustomerInformation viewCustomerByEmail(HttpServletRequest req, @PathVariable("email") String email)
			throws CustomerException, CustomerEmailIdnotFound {

		return bookservice.viewByEmailId(email);
		
	}

}
