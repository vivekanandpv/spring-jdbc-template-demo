package com.example.demo.models;

import java.util.List;
import java.util.Set;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean isActive;
	private Set<Account> accounts;
	
	public Customer() {
		
	}
	
	

	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Set<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
