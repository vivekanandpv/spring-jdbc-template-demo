package com.example.demo.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repositories.ICustomerRepository;
import com.example.demo.services.interfaces.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	private final ICustomerRepository repository;
	
	
	public CustomerService(ICustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.repository.getCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		return this.repository.getCustomer(id);
	}

	@Override
	public Customer getCustomerById(String pan) {
		return null;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return this.repository.createCustomer(customer);
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		return this.repository.updateCustomer(customer);
	}

	@Override
	public String deleteCustomer(int id) {
		this.repository.deleteCustomer(id);
		return "Deleted customer with id: " + id;
	}
}
