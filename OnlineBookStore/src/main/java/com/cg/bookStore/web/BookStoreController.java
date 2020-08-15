package com.cg.bookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.QueryResponseDTO;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.BookStoreServiceException;
import com.cg.bookStore.service.BookStoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService bookStoreService;
	/*********************************************************************************************************************
	 * Method: getUserList
	 * Description: handler mapped with get function to get request from the ui. fetches the user list
	 * 
	 * @param adminId:  Admin's userId
	 * @return userList: list containing the objects of admins from the database            
     *  Created By - Kunal Maheshwari
	 * 
	 ***********************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/admin/getallusers/{adminId}")
	public ResponseEntity<List<Admin>> getUserList(@PathVariable("adminId") int adminId)
	{ 
		List<Admin> userList;
		userList=bookStoreService.getUserList(adminId);
		return new ResponseEntity<List<Admin>>(userList,HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(path = "/admin/getallcustomers/{adminEmail}/{adminPassword}/{adminId}/{pageNumber}")
	public ResponseEntity<Object> getAllCustomers(@PathVariable("adminEmail") String adminEmail,@PathVariable("adminPassword") String adminPassword,@PathVariable("adminId") Integer adminId,@PathVariable("pageNumber") Integer pageNumber)
	{
		QueryResponseDTO queryResponse=bookStoreService.getAllCustomers(adminEmail, adminPassword, adminId, pageNumber);
		
		return new ResponseEntity<>(queryResponse,HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/admin/deleteCustomer/{email}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String email) {
		bookStoreService.deleteCustomer(email);
		return new ResponseEntity<String>("{\"data\":\"Customer deleted Sucessfully\"} ", HttpStatus.OK);
	}
	@CrossOrigin
	@DeleteMapping("/admin/deleteUser/{adminId}")
	public ResponseEntity<String> deleteUser(@PathVariable int adminId) throws BookStoreServiceException {
		String response="";
		boolean result = bookStoreService.deleteUser(adminId);
		if (result) {
			response = "{\"data\":\"Customer deleted Sucessfully\"} ";
		} 
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	/**********************************************************************************
	* Method        addAdmin
	* Description   To add another admin 
	* returns       This method return string to tell if new admin is created or not.
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	 * @throws BookStoreServiceException
	**********************************************************************************/
	
	@CrossOrigin
	@PostMapping(value="/admin/addAdmin",consumes= {"application/json"})
	public String addAdmin(@RequestBody Admin admin) throws BookStoreServiceException
	{
		try 
		{	
			return bookStoreService.addAdmin(admin);
		}
		catch(NullPointerException bookStoreException)
		{
			throw new BookStoreServiceException("Please Enter Valid Input");
		}
	}
	@CrossOrigin
	@PutMapping("/admin/editAdmin/{adminId}")
	public String editAdmin(@PathVariable int adminId, @RequestBody Admin admin) throws BookStoreServiceException {
		try{
			
			return bookStoreService.editAdmin(adminId, admin);
			} catch(Exception exception) {
				throw new BookStoreServiceException(exception.getMessage());
			}
	}
	@CrossOrigin
	@PostMapping("/admin/addcustomers")
	public String addCustomer(@RequestBody CustomerInformation customerInformation) throws BookStoreServiceException
	{
		System.out.println("Came to Controller ");
		try {
			boolean status=bookStoreService.saveCustomer(customerInformation);
			if(!status) {
			
			throw new BookStoreServiceException("Can't Perform Signup Process! Check your Entered data is correct");
			}
		
		}
		catch(Exception e) {
			throw new BookStoreServiceException("Email Id already exist");
		}
		return "Customer Profile Created Successfully";
		
	}
	@CrossOrigin
	@GetMapping("/customerlogin")
	public ResponseEntity<CustomerInformation> customerlogin(String email,String password) throws BookStoreServiceException {
		CustomerInformation customer=bookStoreService.loginCustomer(email, password);
		return new ResponseEntity<CustomerInformation>(customer, HttpStatus.OK);
		
	}
	@CrossOrigin
	@GetMapping("/adminlogin")
	public ResponseEntity<Admin> adminlogin(String email,String password) throws BookStoreServiceException {
		
		Admin admin=bookStoreService.loginAdmin(email, password);
		
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping("admin/updatecustomer/{email}")
	public ResponseEntity<String> updateCustomer(@PathVariable("email") String email,@RequestBody CustomerInformation customer) throws BookStoreServiceException {
		bookStoreService.editCustomer(email,customer);
		return new ResponseEntity<String>("Customer Updated Successfully",HttpStatus.OK);	
		}
}
