package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Customer;

public interface ICustomerRepository {
	List<Customer> getCustomers();
	Customer getCustomer(int id);
	Customer createCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(int id);
}
