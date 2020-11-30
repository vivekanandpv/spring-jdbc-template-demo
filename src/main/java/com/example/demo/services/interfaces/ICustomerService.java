package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.models.Customer;

public interface ICustomerService {

	List<Customer> getAllCustomers();

	Customer getCustomerById(int id);

	Customer getCustomerById(String pan);

	Customer createCustomer(Customer customer);

	Customer updateCustomer(int id, Customer customer);

	String deleteCustomer(int id);

}