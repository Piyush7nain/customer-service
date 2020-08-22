package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
			
			
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository repo) {
		this.customerRepository = repo;
	}
	
	@Override
	@Transactional	
	public Iterable<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Customer> findCustomerById(int customerId) {
		return customerRepository.findById(customerId);
	}
	
	@Override
	@Transactional
	public Optional<Customer> findCustomerByName(String customerName){
		return customerRepository.findCustomerByCustomerName(customerName);
	}
		@Override
	@Transactional
	public Customer addCustomer(Customer customer){
		return customerRepository.save(customer);
	}
	
	@Override
	@Transactional
	public String deleteById(int id) {
		String name = customerRepository.findById(id).get().getCustomerName();
		customerRepository.deleteById(id);
		return name;
	}

	@Override
	public List<Orders> getOrdersByCustomerId(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		logger.info("Customer -> ", customer.get());
		List<Orders> order = customer.get().getOrders();
		logger.info("Order -> ", order);
		return order;
	}

}
