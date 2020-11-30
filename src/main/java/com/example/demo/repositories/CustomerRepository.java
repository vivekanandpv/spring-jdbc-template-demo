package com.example.demo.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Customer;
import com.example.demo.utils.CustomerRowMapper;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

	private final JdbcTemplate jdbcTemplate;

	public CustomerRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> getCustomers() {
		String sql = "SELECT id, first_name, last_name, email, phone, active FROM customers";
		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Customer getCustomer(int id) {
		String sql = "SELECT id, first_name, last_name, email, phone, active FROM customers WHERE id =?";
		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		String sql = "INSERT INTO public.customers(first_name, last_name, email, phone, active)	VALUES (?, ?, ?, ?, ?) RETURNING id";
		int id = this.jdbcTemplate.queryForObject(sql, new Object[] { customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getPhone(), customer.isActive() }, Integer.class);
		return this.getCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String sql = "UPDATE public.customers SET first_name = ?, last_name = ?, email =?, phone =?, active =? WHERE id=?";
		this.jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getPhone(), customer.isActive(), customer.getId());
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM public.customers WHERE id=?";
		this.jdbcTemplate.update(sql, id);
	}

}
