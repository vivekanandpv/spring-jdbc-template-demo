package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.models.Customer;
import com.example.demo.viewmodels.CustomerCreateViewModel;
import com.example.demo.viewmodels.CustomerPageViewModel;
import com.example.demo.viewmodels.CustomerUpdateViewModel;
import com.example.demo.viewmodels.CustomerViewModel;

public interface ICustomerService {

	List<CustomerViewModel> get();

	CustomerViewModel get(int id);

	CustomerViewModel get(String pan);

	CustomerViewModel create(CustomerCreateViewModel viewModel);

	void update(int id, CustomerUpdateViewModel viewModel);

	void delete(int id);

	default CustomerPageViewModel getPage() {
		return new CustomerPageViewModel();
	}
}