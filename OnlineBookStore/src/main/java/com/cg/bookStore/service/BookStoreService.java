package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.dto.QueryResponseDTO;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.BookNotFoundException;
import com.cg.bookStore.exceptions.BookStoreServiceException;
import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;
import com.cg.bookStore.exceptions.InvalidCustomerIdException;
import com.cg.bookStore.exceptions.InvalidQuantityException;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.exceptions.RecordNotFoundException;

public interface BookStoreService {
	List<BookInformation> viewfavoriteBooksByRating() throws BookException;
	
	List<BookInformation> viewtop4favoriteBooksByRating() throws BookException;

	List<BookInformation> viewAllBooksSer() throws BookException;

	BookInformation viewBookById(int bookId) ;

	List<BookInformation> viewBooksByCategory(int categoryId) throws InvalidCategoryIdException;
	
	public List<BookCategory> viewBooksCategorys();
	
	public  List<BookInformation> getAllRecentlyPublishedBooks() throws  BookException;
	
	public  List<BookInformation> getAll4RecentlyPublishedBooks() throws  BookException;

	public List<BookInformation> getBestSellingBooks();
	
	public List<BookInformation> get4BestSellingBooks();
	
    public CustomerInformation viewCustomer(String customerId) throws CustomerException, CustomerIdNotFoundException;
	
	public CustomerInformation viewByEmailId(String email) throws CustomerException, CustomerEmailIdnotFound;
	
	// Team ----1 ///
	
	public List<Admin> getUserList(int adminId);

	QueryResponseDTO getAllCustomers(String adminEmail, String adminPassword, int adminId, int pageNumber);

	public void deleteCustomer(String email);

	String editAdmin(int adminId, Admin admin) throws BookStoreServiceException;

	Admin loginAdmin(String email, String password) throws BookStoreServiceException;

	String addAdmin(Admin admin) throws BookStoreServiceException;

	boolean saveCustomer(CustomerInformation customerInfromation);

	CustomerInformation loginCustomer(String email, String password) throws BookStoreServiceException;

	boolean deleteUser(int adminId) throws BookStoreServiceException;

	void editCustomer(String email,CustomerInformation customer);
	
	
	//Team----5//
	
	public List<BookInformation> viewBooks() throws RecordNotFoundException;
	
	public List<CartInformation> viewCartByCustomerId(int customerId);
	
	public String addBookToCart(int bookId, int customerId, String status)  throws BookNotFoundException, InvalidQuantityException;

	public boolean removeCartItem(int cartId);

	public boolean clearCartByCustomerId(int customerId);

	public String updateCart(int cartId,int quantity) throws InvalidQuantityException ;
	
	public OrderInformation addOrder(OrderInformation order) throws RecordAlreadyPresentException;
	
	public OrderInformation viewOrderById(int id);
	
	public CustomerInformation viewCustomerById(int customerId)  throws InvalidCustomerIdException;
	
	public Iterable<OrderInformation> listAllOrder();
	
	public List<OrderInformation> viewOrderByCustomerId(int customerId) throws InvalidCustomerIdException;
	
	public void updateStatus(OrderInformation order);	
	
}
