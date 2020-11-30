package com.example.demo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.models.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));
		customer.setPhone(rs.getString("phone"));
		customer.setActive(rs.getBoolean("active"));
		
		return customer;
	}

}
