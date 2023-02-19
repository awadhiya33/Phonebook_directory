package com_persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com_entity.Contact_Details;
import com_entity.Login;


public class ContactOperation_Implementations implements ContactOperation_declerations {

	@Override
	public int Login(Login l)  throws ClassNotFoundException, SQLException  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root","Vidyanshu@12");
		
		
		 String q = "SELECT * FROM user WHERE userName = '"+ l.getUserName()+ "'  and password = '" + l.getPassword()+ "'"  ;
		 
		 
		 Statement stm =con.createStatement();
         ResultSet rest = stm.executeQuery(q);
       //  System.out.println(rest.next()+ q);
         if (rest.next ())
         { 
        	 return rest.getInt(1) ;
         }
         else 
        	 return 0 ;
	}

	@Override
	public int Register(Login l) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root","Vidyanshu@12");
		PreparedStatement ps=con.prepareStatement("insert into user ( userName , password ) values ( ?  , ? );");
		ps.setString(1,l.getUserName());
		ps.setString(2,l.getPassword());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}

	@Override
	public int addContact(Contact_Details c, String username ,int j ) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory", "root", "Vidyanshu@12");
		
		String query="insert into ContactDetails"
				+"(firstName,lastName,phoneNumber,email,address,userId)"
				+"values(?,?,?,?,? ,?)";
	
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getPhoneNmuber());
		ps.setString(4, c.getEmail());
		ps.setString(5,c.getAddress());
		ps.setInt(6, j);
		
		int i=ps.executeUpdate();
		con.close();
		return i;
	}

	@Override
	public ArrayList<Contact_Details> SearchContact(String contact)  throws SQLException, ClassNotFoundException {
		 ArrayList<Contact_Details> contactList = new ArrayList<Contact_Details>();
	        Contact_Details c = null;
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); 	
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory", "root", "Vidyanshu@12"); 
	        String data = contact.trim();
	        String q = ("select * from contactDetails  where firstname like '%" + data + "%' or lastname like '%" + data + "%' or firstname  + ' ' + lastname like 's%'");
	        PreparedStatement pst = con.prepareStatement(q);
	        
	        ResultSet rs = pst.executeQuery();
	        
	        
	        while (rs.next()) {
	          
	            
	                c = new Contact_Details();
	                c.setFirstName(rs.getString(2));
	                c.setLastName(rs.getString(3));
	                c.setPhoneNmuber(rs.getString(4));
	                c.setEmail(rs.getString(5));
	                c.setAddress(rs.getString(6));
	                contactList.add(c);
	            }
	            con.close();
	            return contactList;
	}

	@Override
	public int validatePhoneNumber(String phoneNumber) throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set phoneNumber=? where phoneNumber=?");
		ps.setString(1, phoneNumber);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int UpdateFirstName(String phoneNumber, String firstName) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set firstName=? where phoneNumber=?");
		ps.setString(1, firstName);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int UpdateLastName(String phoneNumber, String lastName)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set lastName=? where PhoneNumber=?");
		ps.setString(1, lastName);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int UpdatePhoneNumber(String phoneNumber, String newPhoneNumber)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set phoneNumber=? where phoneNumber=?");
		ps.setString(1, newPhoneNumber);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int UpdateEmail(String phoneNumber, String email)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set email=? where phoneNumber=?");
		ps.setString(1, email);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int UpdateAddress(String phoneNumber, String address)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory","root", "Vidyanshu@12");
		PreparedStatement ps = con.prepareStatement("update contactDetails set address=? where phoneNumber=?");
		ps.setString(1, address);
		ps.setString(2, phoneNumber);
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int DeleteContact(String pNumber) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory", "root", "Vidyanshu@12");
		
		String query="delete from contactDetails where phoneNumber=?";
		
		
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1,pNumber);
		int i = p.executeUpdate();
		con.close();
		return i;
		
	}

	@Override
	public ArrayList<Contact_Details> ShowAllContacts(String username )  throws SQLException, ClassNotFoundException {
		
		ArrayList <Contact_Details > list = new ArrayList <Contact_Details > ();
		Contact_Details cd = null ;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookdirectory", "root", "Vidyanshu@12");
		
		String q = "select * from contactdetails where userid = ( select userid from user where username = + '" + username + "')";
		Statement stm =con.createStatement();
        ResultSet rs = stm.executeQuery(q);
        
        while (rs.next())
        {
        	cd = new Contact_Details ();
        	cd.setFirstName(rs.getString(2));
        	cd.setLastName(rs.getString(3));
        	cd.setPhoneNmuber(rs.getString(4));
        	cd.setEmail(rs.getString(5));
        	cd.setAddress(rs.getString(6));
        	list.add(cd);
        	
        }
        con.close();
    	return list;
		
	}

}
