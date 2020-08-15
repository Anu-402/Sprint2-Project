package com.cg.pl;
import java.util.Scanner;

import com.cg.bean.Author;
import com.cg.exception.AuthorException;
import com.cg.service.AuthorServiceImpl;
public class Client {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AuthorServiceImpl service = new AuthorServiceImpl();
			while(true) {		
				System.out.println("---------MENU--------");
				System.out.println("1. Enter New Author");
				System.out.println("2. Update Author");
				System.out.println("3. Delete Author");
				System.out.println("4. Find");
				System.out.println("5. Exit");
				try {
					Author author = new Author();
				System.out.println("Enter your choice");
				String choice = null;
				int a =0;
				a=scanner.nextInt();
				scanner.nextLine();
				switch(a) {
					case 1:
						try {
						System.out.println("Enter firstname");
						String first=scanner.next();
                  		author.setFirstName(first);
						System.out.println("Enter middlename");

						author.setMiddleName(scanner.next());
						System.out.println("Enter lastname");

						author.setLastName(scanner.next());
						System.out.println("Enter phone number");

						author.setPhoneNo(scanner.next());
						boolean x=service.addAuthor(author);
						if(x) {
							System.out.println("author added");
						}else {
							System.out.println("author not added");
						}
						}
						catch(AuthorException e)
						{
							System.out.println(e);
						}
						break;
					case 2:
						try {
						System.out.println("Enter author id");

						int id = scanner.nextInt();

						author = service.findAuthor(id);
						if(author!=null) {
							System.out.println("Author eixst");
							System.out.println(author.toString());
							Author temp = new Author();
							temp.setAuthorId(author.getAuthorId());
							System.out.println("Enter firstname");
							temp.setFirstName(scanner.next());
							System.out.println("Enter middlename");
							temp.setMiddleName(scanner.next());
							System.out.println("Enter lastname");
							temp.setLastName(scanner.next());
							System.out.println("Enter phone number");
							temp.setPhoneNo(scanner.next());
							Author x=service.updateAuthor(temp);
							if(x!=null) {
								System.out.println("Author updated");
							}else {
								System.out.println("Not updated");
							}
						}else {
							System.out.println("Author does not exist");
						}
						}
						catch(AuthorException e) {
							System.out.println(e);
						}
						break;
					case 3:
						System.out.println("Enter author id");
						int id = scanner.nextInt();
						Author temp =service.findAuthor(id);
						if(temp!=null) {
						if(service.deleteAuthor(temp)) {
							System.out.println("Author deleted");
						}else {
							System.out.println("Author not deleted");
						}}
						else
							System.out.println(id+" Not Found");
						break;
					case  4 :
						System.out.println(" Enter the Id to search :");
						 id =scanner.nextInt();
						 author =service.findAuthor(id);
						 if(author!=null) {
						 System.out.println("Author Id"+author.getAuthorId());
						 System.out.println("Author First Name"+author.getFirstName());
						 System.out.println("Author Last Name"+author.getLastName());
						 System.out.println("Author Middle Name"+author.getMiddleName());
						 System.out.println("Author Phone Number"+author.getPhoneNo());
						 }
						 else 
							 System.out.println(" No Author is found");
						 break;
					default:
						System.out.println(" Thank You ");
						System.exit(0);
				}
			}
				catch(Exception e) {
					
					System.err.println(" Choice should be integer ");
		    		scanner.nextLine();
				}
		}
	}

}
