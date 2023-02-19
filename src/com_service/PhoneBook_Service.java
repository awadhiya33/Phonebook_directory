package com_service;

import java.sql.SQLException;
import java.util.ArrayList;

import com_entity.Contact_Details;
import com_entity.Login;
import com_persistance.ContactOperation_Implementations;

public class PhoneBook_Service {

	public int login(Login l) throws ClassNotFoundException, SQLException {
	 return new ContactOperation_Implementations().Login(l);
	}

	public int register(Login l) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().Register(l);
	}

	public int addContact(Contact_Details cd , String username, int j)  throws ClassNotFoundException, SQLException{
		return new ContactOperation_Implementations().addContact(cd ,username ,j);
	}

	public ArrayList<Contact_Details> searchContact(String contact) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().SearchContact(contact);
	}

	public int validatePhoneNumber (String phoneNumber) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().validatePhoneNumber (phoneNumber );
	}

	public int updateFirstName(String phoneNumber, String firstName)  throws ClassNotFoundException, SQLException{
		return	new ContactOperation_Implementations().UpdateFirstName (phoneNumber,firstName );
		
	}

	public int updateLastName(String phoneNumber, String lastName) throws ClassNotFoundException, SQLException {
		return	new ContactOperation_Implementations().UpdateLastName(phoneNumber, lastName );
	}

	public int updatePhoneNumber(String phoneNumber, String newPhoneNumber)  throws ClassNotFoundException, SQLException{
		return new ContactOperation_Implementations().UpdatePhoneNumber(phoneNumber, newPhoneNumber  );
	}

	public int updateEmail(String phoneNumber, String email) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().UpdateEmail(phoneNumber, email  );
	}

	public int updateAddress(String phoneNumber, String address) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().UpdateAddress(phoneNumber, address  );
	}

	public int deleteContact(String pNumber) throws ClassNotFoundException, SQLException {
		return new ContactOperation_Implementations().DeleteContact(pNumber  );
	}

	public ArrayList<Contact_Details> showAllContacts(String username)  throws ClassNotFoundException, SQLException{
		return new ContactOperation_Implementations().ShowAllContacts(username);
	}

}
