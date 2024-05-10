package com.mohit;

public class Customer {
	
	int id;
	String firstName;
	String lastName;
	String address;
	long mobile;
	String userName;
	String password;
	
	public Customer() {
		
	}
	public Customer(String firstName,String lastName,String address,long mobile,String userName,String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.mobile=mobile;
		this.userName=userName;
		this.password=password;
	}
	public Customer(int id,String firstName,String lastName,String address,long mobile,String userName,String password) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.mobile=mobile;
		this.userName=userName;
		this.password=password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
