package com.cg.bookStore.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dao.OrderDao;
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
import com.cg.bookStore.exceptions.InvalidCredentialsException;
import com.cg.bookStore.exceptions.InvalidCustomerIdException;
import com.cg.bookStore.exceptions.InvalidQuantityException;
import com.cg.bookStore.exceptions.NoCustomerFoundException;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.exceptions.RecordNotFoundException;
import com.cg.bookStore.exceptions.UserNotFoundException;
import com.cg.bookStore.util.BookStoreConstants;
@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService {
	@Autowired
	private BookStoreDao bookStoreDao;
	
	@Autowired
	private OrderDao orderDao;
	/************************************************************************************
	 * Method: viewfavoredBookser(). 
	 * Description: To Fetch list of all books based on average rating given by customer But throws the exception if no books was available.
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewfavoriteBooksByRating() throws BookException {
		List<BookInformation> bookslist = bookStoreDao.viewfavoriteBooksByRating();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookslist.subList(0, 8);
		return booklist2;
	}
	/************************************************************************************
	 * Method: viewfavoredBooksSer(). 
	 * Description: To Fetch list of all books based on average rating given by customer But throws the exception if no books was available. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewAllBooksSer() throws BookException {
		List<BookInformation> bookslist = bookStoreDao.viewAllBooksdao();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOKS_NOT_AVAILABLE);
		return bookslist;
	}
	@Override
	public BookInformation viewBookById(int bookId) {
		
		return bookStoreDao.viewBookById(bookId);
	}
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) throws InvalidCategoryIdException {	
		List<BookInformation> booksList = bookStoreDao.viewBooksByCategory(categoryId);
		if(booksList.isEmpty())
			throw new InvalidCategoryIdException(BookStoreConstants.BOOKS_NOT_AVAILABLE);
		
		return booksList;
	}
	@Override
	public List<BookCategory> viewBooksCategorys() {
		return bookStoreDao.viewallCategories();
	}
	@Override
	public List<BookInformation> getAllRecentlyPublishedBooks() throws  BookException {
		List<BookInformation> bookList = bookStoreDao.getAllRecentlyPublishedBooks();
		if(bookList.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookList.subList(0, 8);
		return booklist2;
	}
	@Override
	public List<BookInformation> getAll4RecentlyPublishedBooks() throws  BookException {
		List<BookInformation> bookList = bookStoreDao.getAllRecentlyPublishedBooks();
		if(bookList.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookList.subList(0, 4);
		return booklist2;
	}
	@Override
	public List<BookInformation> viewtop4favoriteBooksByRating() throws BookException {
		List<BookInformation> bookslist = bookStoreDao.viewfavoriteBooksByRating();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookslist.subList(0, 4);
		return booklist2;
	}
	@Override
	public List<BookInformation> getBestSellingBooks(){
		List<CartInformation> cartList = bookStoreDao.getBestSellingBooks();
		List<BookInformation> bookList=new ArrayList<BookInformation>();
		int i=0;
		while(i<cartList.size()) {
			bookList.add(cartList.get(i).getBook());
			i++;
		}
		Map<Integer,BookInformation> booksMap=new HashMap<Integer, BookInformation>();
		List<BookInformation> sellingBooks=new ArrayList<BookInformation>();
		i=0;
		while(i<bookList.size()) {
			if(booksMap.put(bookList.get(i).getBookId(), bookList.get(i)) != null) {
				sellingBooks.add(bookList.get(i));
			}
			i++;
		}
		bookList.clear();
		booksMap.clear();
		List<BookInformation> sellingbooklist2 = sellingBooks.subList(0, 4);
		return sellingbooklist2;
	}
	@Override
	public List<BookInformation> get4BestSellingBooks() {
		List<CartInformation> cartList = bookStoreDao.getBestSellingBooks();
		List<BookInformation> bookList=new ArrayList<BookInformation>();
		int i=0;
		while(i<cartList.size()) {
			bookList.add(cartList.get(i).getBook());
			i++;
		}
		Map<Integer,BookInformation> booksMap=new HashMap<Integer, BookInformation>();
		List<BookInformation> sellingBooks=new ArrayList<BookInformation>();
		i=0;
		while(i<bookList.size()) {
			if(booksMap.put(bookList.get(i).getBookId(), bookList.get(i)) != null) {
				sellingBooks.add(bookList.get(i));
			}
			i++;
		}
		bookList.clear();
		booksMap.clear();
		List<BookInformation> sellingbooklist2 = sellingBooks.subList(0, 8);
		return sellingbooklist2;
	}
	
	@Override
	public CustomerInformation viewCustomer(String customerId) throws CustomerException, CustomerIdNotFoundException {

		if (!customerId.matches("^[0-9]{3}$"))
			throw new CustomerException("Id must be a number and only three digit");
		else if (bookStoreDao.viewCustomer(Integer.parseInt(customerId)) == null)
			throw new CustomerIdNotFoundException("Customer Id not Found");
		else
			return bookStoreDao.viewCustomer(Integer.parseInt(customerId));

	}

	@Override
	public CustomerInformation viewByEmailId(String email) throws CustomerException, CustomerEmailIdnotFound {

		if (!email.matches("^(.+)@(.+)$"))
			throw new CustomerException("Email ID must be Unique");
		else if (bookStoreDao.viewCustomerByEmail(email) == null)
			throw new CustomerEmailIdnotFound("Customer Email ID not found");
		else
			return bookStoreDao.viewCustomerByEmail(email);
	}
	
	//  Team -1 //
	
	/*********************************************************************************************************************
	 * Method: getUserList
	 * Description: checks wheater the loggedin Admin is valid. and then ask for list of other admins
	 * 
	 * @param adminId:  Admin's userId
	 * @throws UserNotFoundException: if the admin is an invalid or not present in the database.
	 * @return userList: list containing the objects of admins from the database            
     *  Created By - Kunal Maheshwari
	 ***********************************************************************************************************************/
	@Override
	public List<Admin> getUserList(int adminId) {
		Admin admin=bookStoreDao.getAdmin(adminId);
		if(admin==null)
			throw new UserNotFoundException("User might be removed or not available");
		List<Admin> userList;
		userList=bookStoreDao.retreiveList(adminId);
		return userList;
	}
	
	@Override
	public void deleteCustomer(String email)
	{
		CustomerInformation customer=bookStoreDao.getCustomerByEmail(email);
		boolean customerReviewStatus = bookStoreDao.getCustomerReviewStatus(customer.getCustomerId());
		
		if(customerReviewStatus==true)
		{   
			throw new UserNotFoundException("cannot delete as review is found");
		}
		
		boolean orderInformationStatus = bookStoreDao.getOrderInformationStatus(customer.getCustomerId());
		
		if(orderInformationStatus==true)
		{
			throw new UserNotFoundException("cannot delete as order is found");
		}
		OrderInformation orderToDelete=bookStoreDao.getOrderByCustomer(customer.getCustomerId());
		
		bookStoreDao.deleteCustomer(customer,orderToDelete);
	}
	/********************************************************************************
	 * Method            deleteUser 
	 * Description       for deleting User account
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	
	
	@Override
	public boolean deleteUser(int adminId) throws BookStoreServiceException
	{
		return bookStoreDao.deleteUser(adminId);
	}
	
	@Override
	public QueryResponseDTO getAllCustomers(String adminEmail, String adminPassword, int adminId,
			int pageNumber) {
		if(pageNumber>0)
		{
			if(adminId>0)
			{
					Admin admin=bookStoreDao.getAdmin(adminId);
					if(admin==null)
					{
						throw new InvalidCredentialsException("Invalid credentials!");
					}
					else if(admin.getEmail().equals(adminEmail) && admin.getPassword().equals(adminPassword))
					{
						return bookStoreDao.getAllCustomers(pageNumber);
					}
					else
					{
						throw new InvalidCredentialsException("Invalid Credentials!");
					}
			}
			else
			{
				throw new InvalidCredentialsException("Credentials are invalid");
			}
		}
		else
		{
			throw new NoCustomerFoundException("Invalid page numnber");
		}
	}
	
	
	
	@Override
	public void editCustomer(String email,CustomerInformation customer)
	{   
		CustomerInformation updatedCustomer=bookStoreDao.getCustomerByEmail(email);
		if(updatedCustomer==null)
			throw new UserNotFoundException("Provided details can be updated as an user is not found");
		updatedCustomer.setCity(customer.getCity());
		updatedCustomer.setCountry(customer.getCountry());
		updatedCustomer.setFullName(customer.getFullName());
		updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
		updatedCustomer.setZipCode(customer.getZipCode());
		
		bookStoreDao.updateCustomer(updatedCustomer);
	}
	
	String regexForPassword = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,16}$";
	
	
	Pattern patternForPassword = Pattern.compile(regexForPassword);
	
	/*//**********************************************************************************
	* Method        addAdmin
	* Description   This method will check all the validation and Exception if entered
	*                 details are correct then only it will send data to dao layer
	* returns       This method return string to tell the admn if another admin is created or not.
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	 * @throws BookStoreServiceException
	**********************************************************************************/
	
	@Override
	public String addAdmin(Admin admin) throws BookStoreServiceException {
		
		boolean check=bookStoreDao.checkAdminByEmail(admin.getEmail());
		if(check==true)
		{
			throw new BookStoreServiceException("Entered email id is already exists");
		}
		
		if(admin.getEmail().equals("") || (admin.getEmail().length()<11 || admin.getEmail().length()>64))
		{
            throw new BookStoreServiceException("Please Enter Valid Email Id");
		}
		
		else if(admin.getFullName().equals("") || (admin.getFullName().length()<8 || admin.getFullName().length()>30) )
		{
			throw new BookStoreServiceException("Name Can't Be Empty having length between 8 and 30");
		}
		
		
		else if(admin.getPassword().equals("") || (admin.getPassword().length()<8 || admin.getPassword().length()>16))
		{
			throw new BookStoreServiceException("Password shouldn't be empty having length between 8 to 16 ");

		}
		
		Matcher matcher = patternForPassword.matcher(admin.getPassword());
		
		System.out.println(matcher.matches());
	    if(matcher.matches()==false)
		{
		throw new BookStoreServiceException("Password Must have  alteast one special ,one numeric, one capital character");
		}
	    bookStoreDao.saveAdmin(admin);
	    return "New Admin Created Successfully";
		
	}

	
	
	
	@Override
	public String editAdmin(int adminId, Admin admin) throws BookStoreServiceException{
		if(bookStoreDao.editAdmin(adminId, admin))
			return "Admin updated";
		else
			throw new BookStoreServiceException("Admin not found.");
	}

	
	@Override
	public boolean saveCustomer(CustomerInformation customer) {
		
		Date dateNow = new Date( );
	    
		/*************************************************************************************************************
		 * To set date in specific format
		 **************************************************************************************************************/
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
				
				
		if(customer.getEmailAddress()==null || customer.getCity()==null || customer.getCountry()==null || customer.getEmailAddress()==null || customer.getFullName()==null || 
				customer.getPassword()==null || customer.getAddress()==null ||customer.getPhoneNumber()==null || customer.getZipCode()==0  )
			throw new BookStoreServiceException("A data filed is not correct");
		
	    customer.setRegisterDate(objectOfSimpleDateFormat.format(dateNow));
		bookStoreDao.saveCustomer(customer);
		
		return true;
	}
	
	@Override
	public CustomerInformation loginCustomer(String email, String password) throws BookStoreServiceException {
		
		if(!bookStoreDao.checkCustomerByEmail(email))
				throw new BookStoreServiceException("You are not registered with this email");
		
		
		CustomerInformation customer=bookStoreDao.getCustomerByEmail(email);
		
		if(customer.getPassword().equals(password)==false)
				throw new BookStoreServiceException("The password does not match with the Email provided");
			
		return customer;
	}
	
	@Override
	public Admin loginAdmin(String email, String password) throws BookStoreServiceException {
		if(!bookStoreDao.checkAdminByEmail(email))
				throw new BookStoreServiceException("You are not registered with this email");
		
		Admin admin=bookStoreDao.getAdminByEmail(email);
		
		if(admin.getPassword().equals(password)==false)
				throw new BookStoreServiceException("The password does not match with the Email provided");
		return admin;
	}
	
	//Team------5//
	
	
	@Override
	public String addBookToCart(int bookId, int customerId, String status)
			throws BookNotFoundException, InvalidQuantityException {
		BookInformation book = bookStoreDao.getBook(bookId);
		List<CartInformation> cartList = bookStoreDao.viewCartByCustomerId(customerId);
		int quantity = 1;
		CartInformation cartInfo = new CartInformation();

		if (book == null) {
			throw new BookNotFoundException(BookStoreConstants.BOOK_ID_EXCEPTION);
		}

		if (cartList.isEmpty()) {
			float subTotal = book.getPrice();
			cartInfo.setBook(book);
			cartInfo.setQuantity(quantity);
			cartInfo.setSubTotal(subTotal);
			cartInfo.setCustomerId(customerId);
			cartInfo.setStatus(status);
			return bookStoreDao.addBookToCart(cartInfo);
		} else {

			for (CartInformation cart1 : cartList) {
				if (cart1.getBook().getBookId() == bookId) {
					int cartId = cart1.getCartId();
					int quan = cart1.getQuantity();
					int updatedQuantity = quan + 1;
					updateCart(cartId, updatedQuantity);
					return bookStoreDao.addBookToCart(cart1);
				}

			}

			float subTotal = book.getPrice();
			cartInfo.setBook(book);
			cartInfo.setQuantity(quantity);
			cartInfo.setSubTotal(subTotal);
			cartInfo.setCustomerId(customerId);
			cartInfo.setStatus(status);
			return bookStoreDao.addBookToCart(cartInfo);
		}
	}

	@Override
	public List<BookInformation> viewBooks() throws RecordNotFoundException {

		List<BookInformation> blist = bookStoreDao.viewBooks();
		if (blist.isEmpty())
			throw new RecordNotFoundException();
		return blist;
	}

	@Override
	public List<CartInformation> viewCartByCustomerId(int customerId) {
		List<CartInformation> reviewList = bookStoreDao.viewCartByCustomerId(customerId);
		return reviewList;
	}

	@Override
	public boolean removeCartItem(int cartId) {
		CartInformation cart = bookStoreDao.viewCartByCartId(cartId);
		return bookStoreDao.removeCartItem(cart);
	}

	@Override
	public boolean clearCartByCustomerId(int customerId) {
		List<CartInformation> carts = bookStoreDao.viewCartByCustomerId(customerId);
		int i = 0;
		while (i < carts.size()) {
			bookStoreDao.removeCartItem(carts.get(i));
			i++;
		}
		return true;
	}

	public String updateCart(int cartId, int quantity) throws InvalidQuantityException {
		CartInformation cart = bookStoreDao.viewCartByCartId(cartId);
		if (quantity < 0) {
			throw new InvalidQuantityException();
		} else {
			float updatedSubtotal = quantity * cart.getBook().getPrice();
			cart.setQuantity(quantity);
			cart.setSubTotal(updatedSubtotal);
			bookStoreDao.updateCartQuantity(cart);
		}
		return "Cart Updated";

	}

	@Override
	public OrderInformation addOrder(OrderInformation order) throws RecordAlreadyPresentException {
		Optional<OrderInformation> newOrder = orderDao.findById(order.getOrderId());
		if (newOrder.isPresent()) {
			throw new RecordAlreadyPresentException();
		} else {
			orderDao.save(order);
			updateStatus(order);
			return order;
		}
	}

	@Override
	public void updateStatus(OrderInformation order) {
		List<CartInformation> cartList=order.getCart();
		for(CartInformation c: cartList) {
			c.setStatus("order");
			bookStoreDao.updateCartStatus(c);
		}
	}
	
	@Override
	public OrderInformation viewOrderById(int id) {
		Optional<OrderInformation> order = orderDao.findById(id);
		if (!order.isPresent()) {
			throw new RecordNotFoundException();
		} else
			return order.get();
	}

	@Override
	public Iterable<OrderInformation> listAllOrder() {
		Iterable<OrderInformation> list = orderDao.findAll();
		if (list == null) {
			throw new RecordNotFoundException();
		} else
			return list;
	}

	@Override
	public List<OrderInformation> viewOrderByCustomerId(int customerId) throws InvalidCustomerIdException {
		List<OrderInformation> list = bookStoreDao.viewOrderByCustomerId(customerId);
		if (list.isEmpty()) {
			throw new InvalidCustomerIdException(BookStoreConstants.CUSTOMER_ID_EXCEPTION);
		} else
			return list;
	}

	@Override
	public CustomerInformation viewCustomerById(int customerId)  throws InvalidCustomerIdException{
		return bookStoreDao.viewCustomerById(customerId);
	}
	
}
