package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.dto.QueryResponseDTO;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;

public interface BookStoreDao {

	public List<BookInformation> viewBooksInCategory(int categoryId) throws InvalidCategoryIdException;

	public List<BookInformation> viewfavoriteBooksByRating();

	public List<BookInformation> viewAllBooksdao();

	public BookInformation viewBookById(int bookId);

	public List<BookInformation> viewBooksByCategory(int categoryId);

	public List<BookCategory> viewallCategories();

	public List<BookInformation> getAllRecentlyPublishedBooks() throws BookException;

	public List<CartInformation> getBestSellingBooks();

	public CustomerInformation viewCustomer(Integer customerId);

	public CustomerInformation viewCustomerByEmail(String email);

	// Team --------------------------1/////////////////
	public CustomerInformation getCustomerByEmail(String email);

	public void deleteCustomer(CustomerInformation customer, OrderInformation order);

	boolean saveCustomer(CustomerInformation customer);

	CustomerInformation getCustomer(Integer customer_id);

	boolean checkCustomerByEmail(String emailAddress);

	public String updateCustomer(CustomerInformation updatedCustomer);

	void saveAdmin(Admin admin);

	public Admin getAdmin(int adminId);

	boolean editAdmin(int adminId, Admin admin);

	boolean deleteUser(int adminId);

	boolean checkAdminByEmail(String email);

	Admin getAdminByEmail(String email);

	public boolean getCustomerReviewStatus(int customerId);

	public boolean getOrderInformationStatus(int customerId);

	public List<Admin> retreiveList(int adminId);

	QueryResponseDTO getAllCustomers(int pageNumber);

	OrderInformation getOrderByCustomer(int customerId);

	// Team --------------------------5/////////////////

	public List<CartInformation> viewCartByCustomerId(int customerId);

	public List<BookInformation> viewBooks();

	public BookInformation getBook(int bookId);

	public String addBookToCart(CartInformation cart);

	public boolean removeCartItem(CartInformation cart);

	public CartInformation viewCartByCartId(int cartId);

	public CustomerInformation viewCustomerById(int customerId);

	public boolean updateCartQuantity(CartInformation cart);

	public List<OrderInformation> viewOrderByCustomerId(int customerId);

	boolean updateCartStatus(CartInformation cart);

}
