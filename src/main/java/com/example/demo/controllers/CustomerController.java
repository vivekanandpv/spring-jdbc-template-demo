package com.example.demo.controllers;

import java.util.List;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.viewmodels.CustomerCreateViewModel;
import com.example.demo.viewmodels.CustomerUpdateViewModel;
import com.example.demo.viewmodels.CustomerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<List<CustomerViewModel>> getAllCustomers() {
		return ResponseEntity.ok(this.customerService.get());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerViewModel> getCustomerById(@PathVariable int id) {
		return ResponseEntity.ok(customerService.get(id));
	}

	@PostMapping
	public ResponseEntity<CustomerViewModel> createCustomer(@RequestBody CustomerCreateViewModel viewModel) {
		return ResponseEntity.ok(customerService.create(viewModel));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody CustomerUpdateViewModel viewModel) {
		this.customerService.update(id, viewModel);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		this.customerService.delete(id);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler
	public ResponseEntity<?> handleRecordNotFound(RecordNotFoundException rnef) {
		//	logging this exception
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler
	public ResponseEntity<?> handleOtherExceptions(Throwable throwable) {
		//	logging this exception
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
	}
}
