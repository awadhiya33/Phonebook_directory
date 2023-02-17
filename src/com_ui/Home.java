package com_ui;

import java.sql.SQLException;
import java.util.Scanner;

import com_entity.Contact_Details;
import com_entity.Login;

public class Home {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while(true) {
			System.out.println("1.Login \n 2.Register \n 3.Exit");
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
			PhoneBook();
		}
		else {
			System.out.println("Enter correct details or user not exist");
		}
		
		
	}
private static void register() throws ClassNotFoundException, SQLException {
		Login l=new Login();
		System.out.println("Enter userid username password");
		
		l.setUserName(sc.next());
		l.setPassword(sc.next());
		int i=new PhoneBook_Service().register(l);
		if(i!=0) {
			System.out.println("registration done");
		}
		else {
			System.out.println("Enter correct details or user not exist");
		}
		
	}
	public  static void  PhoneBook() {
		
		while (true )
		{
		System.out.println("1. Add contact \n"
				+ "2.Search \n"
				+ "3.Edit \n"
				+ "4.Delete \n"
				+ "5.Contact List "
				+ "6.Exit");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: 
			System.out.println("Enter the Contact deatils : firstName ,lastName ,phoneNumber ,email,address ");
			Contact_Details cd = new Contact_Details (sc.next(),sc.next(),sc.next(),sc.next(),sc.next());
			int i = PhoneBook_Service().addContact(cd);
			if (i != 0 )
			{
				System.out.println("added Contact ");
				
			}
			
			else 
			{
				System.out.println("Operation Failed .. Add data Properly ");
			}
			
		case 2:
			System.out.println("Enter the contact name ");
			String contact = sc.next();
			 Contact_Details  c = PhoneBook_Service().searchContact(contact);
			 System.out.println(c.getFirstName()+ " \n"+ c.getLastName() + "\n " + c.getPhoneNmuber()+ "\n"+ c.getEmail()+ "\n" + c.getAddress());
			 
		case 4:
			
			
			
			
			}
		
	}
		}

	

}
