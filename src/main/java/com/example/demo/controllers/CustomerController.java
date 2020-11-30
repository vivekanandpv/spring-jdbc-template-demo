package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customer;
import com.example.demo.services.interfaces.ICustomerService;


@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	private final ICustomerService customerService;

	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return this.customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		if (id < 1000) {
			return new ResponseEntity(this.customerService.getCustomerById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		return this.customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return this.customerService.deleteCustomer(id);
	}
}
