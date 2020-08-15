package com.cg.bookStore.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.dto.QueryResponseDTO;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.entity.CustomerReview;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.BookStoreServiceException;
import com.cg.bookStore.exceptions.ListNotFoundException;
import com.cg.bookStore.exceptions.NoCustomerFoundException;
import com.cg.bookStore.exceptions.UserNotFoundException;

@Repository
public class BookStoreDaoImpl implements BookStoreDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	/*
	 * this layer access the db and searches for that category id and fetches the list
	 * of books and return it to the service layer. 
	 */
	@Override
	public List<BookInformation> viewBooksInCategory(int categoryId) {
		String jpql = "from BookInformation binfo inner join fetch binfo.category c where c.categoryId=:cid";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}
	
	/************************************************************************************
	 * Method: viewfavoredBooksdao(). 
	 * Description: To Fetch list of all books based on average rating given by customer. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewfavoriteBooksByRating() {
		TypedQuery<BookInformation> query = entityManager.createQuery("from BookInformation order by rating desc, title asc",
				BookInformation.class);
		System.out.println(query.getResultList());
		return query.getResultList();

	}

	/************************************************************************************
	 * Method: viewAllBooks() 
	 * Description: To Fetch list of all books.
	 * Created By -K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewAllBooksdao() {
		TypedQuery<BookInformation> query = entityManager.createQuery("from BookInformation b", BookInformation.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	/************************************************************************************
	 * Method: viewBookById() 
	 * Description: To Fetch the book based on book_Id.
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public BookInformation viewBookById(int bookId) {
		return entityManager.find(BookInformation.class, bookId);
	}

	/************************************************************************************
	 * Method: viewBooksByCategory() 
	 * Description: To Fetch list of all books based on category_Id. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) {
		String jpql = "from BookInformation bi inner join fetch bi.category ct where ct.categoryId=:cid";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}

	@Override
	public List<BookCategory> viewallCategories() {
		TypedQuery<BookCategory> query = entityManager.createQuery("from BookCategory c",
				BookCategory.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public List<BookInformation> getAllRecentlyPublishedBooks() throws BookException {
		String queryString = "SELECT Book From BookInformation Book where Book.publishDate BETWEEN :Start " + "AND :Stop Order by Book.publishDate Desc";
		TypedQuery<BookInformation> query = entityManager.createQuery(queryString , BookInformation.class);
		query.setParameter("Start", LocalDate.now().minusMonths(2));
		query.setParameter("Stop", LocalDate.now());
		return query.getResultList();
	}
	
	@Override
	public List<CartInformation> getBestSellingBooks() {
		String jpql = "from CartInformation where status='order'";
		TypedQuery<CartInformation> query = entityManager.createQuery(jpql, CartInformation.class);
		return query.getResultList();
	}
	
	@Override
	public CustomerInformation viewCustomer(Integer customerId) {

		return entityManager.find(CustomerInformation.class, customerId);
	}

	@Override
	public CustomerInformation viewCustomerByEmail(String email) {
		
		String jpql = "from CustomerInformation c where c.emailAddress=:email";
		TypedQuery<CustomerInformation> query = entityManager.createQuery(jpql, CustomerInformation.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
	
	// Team ----1 ////
	/*********************************************************************************************************************
	 * Method: getAdmin
	 * Description: fetched a object of admin with their adminId
	 * 
	 * @param adminId:
	 *            Admin's userId
     *  Created By - Kunal Maheshwari
	 * 
	 ***********************************************************************************************************************/
	@Override
	public Admin getAdmin(int adminId) {
		Admin admin=entityManager.find(Admin.class, adminId);
		return admin;
	}
	
	
	
	
	@Override
	public CustomerInformation getCustomerByEmail(String email)
	{   CustomerInformation customer=null;
		try {
		String Qstr="Select customer From CustomerInformation customer Where customer.emailAddress=:email";
		TypedQuery<CustomerInformation> query=entityManager.createQuery(Qstr, CustomerInformation.class).setParameter("email", email);
		customer=query.getSingleResult();
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("No Customer was Found");
		}
		return customer;
	}
	
	@Override
	public CustomerInformation getCustomer(Integer customer_id) {
		CustomerInformation customer=entityManager.find(CustomerInformation.class, customer_id);
		return customer;
	}

	
	
	
	@Override
	public void deleteCustomer(CustomerInformation customer,OrderInformation order)
	{   
		if(order!=null)
		{	
			entityManager.remove(order);
		}
		entityManager.remove(customer);
	}
	
	
	/********************************************************************************
	 * Method            deleteUser 
	 * Description       for checking whether the account exists or not and then
	 *                   deleting it
	 * returns boolean   returns true if account exists and gets deleted
	 *                   otherwise returns false if account does not exists 
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	@Override
	public boolean deleteUser(int adminId) throws BookStoreServiceException{
		
		if(entityManager.contains(entityManager.find(Admin.class, adminId)))
		{
		Admin user = entityManager.find(Admin.class, adminId);
		entityManager.remove(user);
		return true;
		}
		else
		{
			throw new BookStoreServiceException("User Not found");
		}
	
	}
	
	
	@Override
	public QueryResponseDTO getAllCustomers(int pageNumber) {
		
		long totalNoOfPages=0;
		String queryToGetCustomer = "SELECT customer FROM CustomerInformation customer";
		TypedQuery<CustomerInformation> typedQueryForSize=entityManager.createQuery(queryToGetCustomer, CustomerInformation.class);
       
		long totalCount=typedQueryForSize.getResultList().size();
		if(totalCount%10==0)
			totalNoOfPages=totalCount/10;
		else
			totalNoOfPages=totalCount/10+1;
		if(pageNumber<=totalNoOfPages)
		{
			String queryToAllCustomers="SELECT customer FROM CustomerInformation customer WHERE customer.customerId>1 ORDER BY customerId DESC";
			
			TypedQuery<CustomerInformation> typedQueryForFetchingCustomers=entityManager.createQuery(queryToAllCustomers, CustomerInformation.class);
			
			typedQueryForFetchingCustomers.setFirstResult((pageNumber-1)*10); 
			typedQueryForFetchingCustomers.setMaxResults(10);
			
			List<CustomerInformation> resultList=typedQueryForFetchingCustomers.getResultList();
			
			QueryResponseDTO queryResponse=new QueryResponseDTO();
			queryResponse.setCurrentPageNumber(pageNumber);
			queryResponse.setTotalNoOfPages(totalNoOfPages);
			queryResponse.setList(resultList);
			return queryResponse;
		}
		else
		{
			throw new NoCustomerFoundException("Invalid PageNumber");
		}
		
		
	}
	
	/**********************************************************************************
	* Method        getAdminByEmail
	* Description   This method checks if entered email id is present in the database 
	*               or not.  
	* returns       it returns admin 
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	**********************************************************************************/
	
	
	@Override
	public Admin getAdminByEmail(String email) {
		String findquery="Select admin FROM Admin admin WHERE admin.email= :email";
		TypedQuery<Admin> query=entityManager.createQuery(findquery,Admin.class).setParameter("email",email);
		return query.getSingleResult();
	}
	
	
	/**********************************************************************************
	* Method        saveAdmin
	* Description   This method persist data of admin to database 
	* returns       it returns nothing
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	**********************************************************************************/
	
	@Override
	public void saveAdmin(Admin admin) {

		entityManager.persist(admin);
		
	}
	
	
	@Override
	public boolean editAdmin(int adminId, Admin admin) {
		Admin editAdmin = entityManager.find(Admin.class, adminId);
		if (editAdmin == null)
			return false;
		editAdmin.setEmail(admin.getEmail());
		editAdmin.setFullName(admin.getFullName());
		editAdmin.setPassword(admin.getPassword());
		entityManager.merge(editAdmin);
		return true;
	}
	
	@Override
	public boolean saveCustomer(CustomerInformation customer) {
		entityManager.persist(customer);
		return true;
		
	}

	/*@Override
	public CustomerInformation FindByCustomerEmail(String emailAddress) {
		
		String findquery="Select customer.emailAddress FROM Customer customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<CustomerInformation> query=entityManager.createQuery(findquery,CustomerInformation.class).setParameter("emailAddress",emailAddress);
		return query.getSingleResult();
	}*/
	

	
	


	@Override
	public boolean checkCustomerByEmail(String emailAddress) {
		String checkquery="Select customer.emailAddress FROM CustomerInformation customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<String> query=entityManager.createQuery(checkquery,String.class).setParameter("emailAddress",emailAddress);
		try {
			
			query.getSingleResult();
		} catch(Exception exception) {
			
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean checkAdminByEmail(String email) {
		String checkquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
		TypedQuery<String> query=entityManager.createQuery(checkquery,String.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
			
		} catch(Exception exception) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean getCustomerReviewStatus(int customerId)
	{   
		List<CustomerReview> reviewList=null;
		try{
		String Qstr="Select review From CustomerReview review Where review.customerId=:customerId";
	    TypedQuery<CustomerReview> query = entityManager.createQuery(Qstr,CustomerReview.class).setParameter("customerId",customerId);
	    reviewList=query.getResultList();
		}
		catch(Exception e)
		{  
			return false;
		}
		if(reviewList.isEmpty())
		{
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean getOrderInformationStatus(int customerId)
	{   //returns false if no order is found
		
		try {
		String Qstr="Select bookStoreOrder From OrderInformation bookStoreOrder Join bookStoreOrder.customerDetails customer Where customer.customerId=:customerId";
		TypedQuery<OrderInformation> query = entityManager.createQuery(Qstr, OrderInformation.class);
		query.getSingleResult();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	/*********************************************************************************************************************
	 * Method: retreiveLsit
	 * Description: retreives a list of users from database
	 * 
	 * @param adminId:
	 *            Admin's userId
	 * 
	 * @throws ListNotFoundException:
	 *             if the list is empty or not found
     *  Created By - Kunal Maheshwari
	 * 
	 ***********************************************************************************************************************/
	@Override
	public List<Admin> retreiveList(int adminId) {
		// TODO Auto-generated method stub
		
		String Qstr="Select admin from Admin admin Where Not admin.adminId =: adminId";
		
		try {
		TypedQuery<Admin> query= entityManager.createQuery(Qstr,Admin.class).setParameter("adminId", adminId);
		return query.getResultList();
		}
		catch(Exception e)
		{
			throw new ListNotFoundException("The List you want to access does not exist");
		}
	}



	@Override
	public String updateCustomer(CustomerInformation updatedCustomer) {
		
		entityManager.merge(updatedCustomer);
		return "Customer Successfully Updated";
	}
	
	@Override
	public OrderInformation getOrderByCustomer(int customerId)
	{
		OrderInformation order=null;
		try
		{
			String Qstr="Select bookStoreOrder From OrderInformation bookStoreOrder Join bookStoreOrder.customerDetails customer Where customer.customerId=:customerId";
			TypedQuery<OrderInformation> query = entityManager.createQuery(Qstr, OrderInformation.class).setParameter("customerId", customerId);
			order=query.getSingleResult();
		}
		catch(Exception e)
		{
			return order;
		}
		return order;
	}
	
	// Team ----5 ////
	
	@Override
	public List<BookInformation> viewBooks() {
		TypedQuery<BookInformation> query = entityManager.createQuery("from BookInformation", BookInformation.class);
		return query.getResultList();
	}

	@Override
	public BookInformation getBook(int bookId) {
		return entityManager.find(BookInformation.class, bookId);
	}

	@Override
	public List<CartInformation> viewCartByCustomerId(int customerId) {
		String jpql = "from CartInformation where customerId=:custId and status='cart'";
		TypedQuery<CartInformation> query = entityManager.createQuery(jpql, CartInformation.class);
		query.setParameter("custId", customerId);
		return query.getResultList();
	}

	@Override
	public String addBookToCart(CartInformation cart) {
		entityManager.persist(cart);
		return "Book Added To Cart Successfully";
	}

	@Override
	public boolean removeCartItem(CartInformation cart) {
		entityManager.remove(cart);
		return true;
	}

	@Override
	public CartInformation viewCartByCartId(int cartId) {
		return entityManager.find(CartInformation.class, cartId);
	}

	@Override
	public boolean updateCartQuantity(CartInformation cart) {
		entityManager.merge(cart);
		return true;
	}
	
	@Override
	public boolean updateCartStatus(CartInformation cart) {
		entityManager.merge(cart);
		return true;
	}

	@Override
	public List<OrderInformation> viewOrderByCustomerId(int customerId) {
		String jpql = "from OrderInformation oi inner join fetch oi.customer c where c.customerId=:custid";
		TypedQuery<OrderInformation> query = entityManager.createQuery(jpql, OrderInformation.class);
		query.setParameter("custid", customerId);
		return query.getResultList();
	}

	@Override
	public CustomerInformation viewCustomerById(int customerId) {
		return entityManager.find(CustomerInformation.class, customerId);
	}
		
}
