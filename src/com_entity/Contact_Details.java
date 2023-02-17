package com_entity;

public class Contact_Details {
    
	private String firstName;
	private String lastName ;
	private String phoneNmuber ;
	private String email;
	private String address ;
	public Contact_Details() {
		
	}
	public Contact_Details( String firstName, String lastName, String phoneNmuber, String email,
			String address) {
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNmuber = phoneNmuber;
		this.email = email;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNmuber() {
		return phoneNmuber;
	}
	public void setPhoneNmuber(String phoneNmuber) {
		this.phoneNmuber = phoneNmuber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Contact_Details [ firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNmuber=" + phoneNmuber + ", email=" + email + ", address=" + address + "]";
	}
	
	
	 
	
}
