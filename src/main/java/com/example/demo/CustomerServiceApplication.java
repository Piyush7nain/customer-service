package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.services.OrderService;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	CustomerRepository customerRepository;
	OrderService orderService;
	
	public CustomerServiceApplication(CustomerRepository repo, OrderService repo1) {
		this.customerRepository = repo;
		this.orderService = repo1;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("John Doe",200000));
		customerRepository.save(new Customer("Marry Public",120000));
		customerRepository.save(new Customer("Demo Name",70000));
		orderService.addOrder(new Orders("mobile"), 1);
		orderService.addOrder(new Orders("mobile"), 2);
		orderService.addOrder(new Orders("mobile"), 3);
		
	}		

		
}
