package com_ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com_entity.Contact_Details;
import com_entity.Login;
import com_service.PhoneBook_Service;

public class Home {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while(true) {
			System.out.println("1.Login \n2.Register \n3.Exit");
			int c=sc.nextInt();
			
			switch(c) {
			case 1:login();
				break;
			case 2:register();
				break;
			case 3:System.exit(0);
			default:System.out.println("Inavalid");
			}
			
			
		}
	}

	private static void login() throws ClassNotFoundException, SQLException {
		Login l =new Login();
		System.out.println("Enter username:");
		l.setUserName(sc.next());
		System.out.println("Enter password:");
		l.setPassword(sc.next());
		
		int i= new PhoneBook_Service ().login(l);
		if(i!=0) {
			System.out.println("login done");
			PhoneBook(l.getUserName(),i );
		}
		else {
			System.out.println("Enter correct details or user not exist");
		}
		
		
	}
private static void register() throws ClassNotFoundException, SQLException {
		Login l=new Login();
		System.out.println("Enter username password");
		
		l.setUserName(sc.next());
		String pswd = sc.next();
		while  ( !validatePassword (pswd )) {
			System.out.println("Enter a valid password ");
				pswd = sc.next();
			}
		
			l.setPassword(pswd);
		int i=new PhoneBook_Service().register(l);
		if(i!=0) {
			System.out.println("registration done");
			return ;
		}
		else {
			System.out.println("Enter correct details or user not exist");
		}
		
	}
	public  static boolean validatePassword(String pswd) {
		
	        String regex = "^(?=.*[0-9])"
	                       + "(?=.*[a-z])(?=.*[A-Z])"
	                       + "(?=.*[@#$%^&+=])"
	                       + "(?=\\S+$).{8,20}$";
	 
	       
	        Pattern p = Pattern.compile(regex);
	 
	      
	        if (pswd == null) {
	            return false;
	        }
	        Matcher m = p.matcher(pswd);
	        
	       
	        return m.matches();
}

	public  static void  PhoneBook(String username  ,int j) throws ClassNotFoundException, SQLException {
		int choice = 0;
		do
		{
		System.out.println("1. Add contact \n"
				+ "2.Search \n"
				+ "3.Update \n"
				+ "4.Delete \n"
				+ "5.Contact List \n"
				+ "6.Exit");
		
		 choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: 
			System.out.println("Enter the Contact deatils : firstName ,lastName ,phoneNumber ,email,address ");
			String firstname = sc.next();
			String lastname  = sc.next();
			String phonenumber  = sc.next();
			while  ( !isValidMobileNo (phonenumber )) {
				System.out.println("Enter a valid phoneNumber ");
					phonenumber  = sc.next();
				}
			
			Contact_Details cd = new Contact_Details (firstname , lastname ,phonenumber ,sc.next(),sc.next());
			int i = new PhoneBook_Service().addContact(cd,username ,j);
			if (i != 0 )
			{
				System.out.println("added Contact ");
				
			}
			
			else 
			{
				System.out.println("Operation Failed .. Add details Properly ");
			}
			break;
			
		case 2:
			System.out.println("Enter the contact name ");
			String contact = sc.next();
			 List <Contact_Details> cd3 = new PhoneBook_Service().searchContact(contact);
		        if(cd3 == null){
		            System.out.println("User not Found");
		        }else{
		           for(Contact_Details c : cd3) {
		            System.out.println(c);
		             }
		          }
			 break;
			 
		case  3:
			
			System.out.println("Enter the phoneNumber of user :");
			int k = 0;
			String  phoneNumber = sc.next();
			int i2 = new PhoneBook_Service().validatePhoneNumber (phoneNumber );
			if ( i2 == 1 )
					{
			while (k != 6)
			{
					System.out.println("Want to Update :\n"
					+ "1.firstname \n"
					+ "2.lastName \n"
					+ "3.phoneNumber \n"
					+ "4.email \n +"
					+ "5.address \n"
					+ "6.Exit ");
			
			 k = sc.nextInt();
			
			switch(k)
			{
			case 1: 
				String firstName  = sc.next();
				int  j1 = new PhoneBook_Service().updateFirstName (phoneNumber ,firstName );
				if (j1 == 1 )
				{
					System.out.println("Updated FirstName ..");
				}
				
				else 
					System.out.println("Opertaion Failed !!" );
				break;
				
			case 2: 
				String lastName = sc.next();
				int j2 = new PhoneBook_Service().updateLastName (phoneNumber,lastName );
				if (j2 == 1 )
				{
					System.out.println("Updated lastName  ..");
				}
				
				else 
					System.out.println("Opertaion Failed !!" );
				break;
				
			case 3 : 
				String newPhoneNumber = sc.next();
				int j3 = new PhoneBook_Service().updatePhoneNumber(phoneNumber ,newPhoneNumber );
						if (j3 == 1 )
						{
							System.out.println("Updated PhoneNumber  ..");
						}
						
						else 
							System.out.println("Opertaion Failed !!" );
						break;
				
			case 4: 
			 
				String email = sc.next();
				int j4 = new PhoneBook_Service().updateEmail(phoneNumber ,email );
						if (j4 == 1 )
						{
							System.out.println("Updated email  ..");
						}
						
						else 
							System.out.println("Opertaion Failed !!" );
						break;
				
			case 5: 
				 
				String address  = sc.next();
				int j5 = new PhoneBook_Service().updateAddress(phoneNumber ,address );
						if (j5 == 1 )
						{
							System.out.println("Updated address  ..");
						}
						
						else 
							System.out.println("Opertaion Failed !!" );
						break;
				
			case 6: 
				
					System.out.println("Modification done !!! ");
				break;
						
			}
			}
					}
					
					else 
					{
						System.out.println("PhoneNumber not found in the database!! Enter Again  ");
					}
					
		
			
		break;
		
		case 4:
			System.out.println("Enter the phoneNumber :");
			String pNumber = sc.next();
			int c1 = new PhoneBook_Service().deleteContact(pNumber );
			
			if (c1 != 0 )
			{
				System.out.println("Contact Deleted");
				
			}
			else 
			{
				System.out.println("Enter no properly /record not found ");
			}
			break;
			
		case 5:
			ArrayList <Contact_Details > list1 = new ArrayList <Contact_Details >();
			list1 = new PhoneBook_Service().showAllContacts(username );
			
			for (Contact_Details cd1 : list1 )
			{
				System.out.println(cd1);
			}
			break;
			
		case 6: 
			System.exit(0);
			
			}
		
	}while (choice != 6 );
		}

	public static boolean isValidMobileNo(String str)  
	{  

	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
	 
	Matcher match = ptrn.matcher(str);  
	
	return (match.find() && match.group().equals(str));  
	}

	

}
