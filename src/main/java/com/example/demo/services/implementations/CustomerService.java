package com.example.demo.services.implementations;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.Customer;
import com.example.demo.repositories.IAccountRepository;
import com.example.demo.viewmodels.*;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ICustomerRepository;
import com.example.demo.services.interfaces.ICustomerService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;


    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerPageViewModel getPage() {
        CustomerPageViewModel vm = new CustomerPageViewModel();
        vm.setCount(customerRepository.count());
        vm.setCurrentIndex(1);
        vm.setGeneratedAt(LocalDateTime.now());
        vm.setnPages(4);
        vm.setCustomers(get());

        return vm;
    }

    @Override
    public List<CustomerViewModel> get() {
        return customerRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerViewModel get(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the customer with id: " + id));

        return toViewModel(customer);
    }

    @Override
    public CustomerViewModel get(String pan) {
        return null;
    }

    @Override
    public CustomerViewModel create(CustomerCreateViewModel viewModel) {
        Customer customer = toEntity(viewModel);
        return toViewModel(customerRepository.saveAndFlush(customer));
    }

    @Override
    public void update(int id, CustomerUpdateViewModel viewModel) {
        Customer customer = findById(id);
        updateEntity(viewModel, findById(id));
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void delete(int id) {
        findById(id);
        customerRepository.deleteById(id);
    }

    private List<AccountViewModel> getAccounts(Customer customer) {
        return customer.getAccounts()
                .stream()
                .map(a -> {
                    AccountViewModel avm = new AccountViewModel();
                    BeanUtils.copyProperties(a, avm);
                    return avm;
                })
                .collect(Collectors.toList());
    }

    private CustomerViewModel toViewModel(Customer customer) {
        CustomerViewModel vm = new CustomerViewModel();
        BeanUtils.copyProperties(customer, vm);
        vm.setAccounts(getAccounts(customer));
        return vm;
    }

    private Customer toEntity(CustomerCreateViewModel viewModel) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(viewModel, customer);
        customer.setActive(true);   //  true at the time of creation
        return customer;
    }

    private void updateEntity(CustomerUpdateViewModel viewModel, Customer customer) {
        BeanUtils.copyProperties(viewModel, customer);
    }

    private Customer findById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the customer with id: " + id));
    }
}
