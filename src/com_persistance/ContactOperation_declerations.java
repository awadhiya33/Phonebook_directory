package com_persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com_entity.Contact_Details;
import com_entity.Login;

public interface ContactOperation_declerations {
	
	public int Login(Login l) throws ClassNotFoundException, SQLException  ;
	public int Register(Login l) throws ClassNotFoundException, SQLException ;
	public int addContact(Contact_Details cd, String username ,int i) throws ClassNotFoundException, SQLException ;
	public ArrayList<Contact_Details> SearchContact(String contact) throws ClassNotFoundException, SQLException ;
	public int validatePhoneNumber (String phoneNumber)  throws ClassNotFoundException, SQLException ;
	public int UpdateFirstName(String phoneNumber, String firstName) throws ClassNotFoundException, SQLException ;
	public int UpdateLastName(String phoneNumber, String lastName) throws ClassNotFoundException, SQLException ;
	public int UpdatePhoneNumber(String phoneNumber, String newPhoneNumber) throws ClassNotFoundException, SQLException ;
	public int UpdateEmail(String phoneNumber, String email) throws ClassNotFoundException, SQLException ;
	public int UpdateAddress(String phoneNumber, String address) throws ClassNotFoundException, SQLException ;
	public int DeleteContact(String pNumber) throws ClassNotFoundException, SQLException ;
	public ArrayList<Contact_Details> ShowAllContacts(String username ) throws ClassNotFoundException, SQLException ;
	
	

}
