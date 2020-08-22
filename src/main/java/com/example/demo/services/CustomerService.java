package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;

public interface CustomerService {
	public Iterable<Customer> getAllCustomer();
	public Optional<Customer> findCustomerById(int customerId);
	public Optional<Customer> findCustomerByName(String customerName);
	public Customer addCustomer(Customer customer);
	public String deleteById(int id);
	public List<Orders> getOrdersByCustomerId(int customerId);
}
