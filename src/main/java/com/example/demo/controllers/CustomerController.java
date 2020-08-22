package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.services.CustomerService;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	
	private com.example.demo.services.CustomerService customerService;
	private OrderService orderService;

	public CustomerController(CustomerService customerService, OrderService orderService) {
		super();
		this.customerService = customerService;
		this.orderService = orderService;
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<Iterable<Customer>> getAllCustomer()
	{
		return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	@GetMapping("/customers/id/{customerId}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customerId") int customerId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerById(customerId));
	}
	
	@GetMapping("/customers/{id}/orders")
	public ResponseEntity<List<Orders>> getOrders(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getOrdersByCustomerId(id));
	}
	
	
	@GetMapping("/customers/name/{customerName}")
	public ResponseEntity<Optional<Customer>> findCustomerByName(@PathVariable("customerName") String customerName)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerByName(customerName));
	}
	
	@PostMapping("/customers/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added " + customer.getCustomerName());	
	}
	
	@DeleteMapping("/customers/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body("Removed " + customerService.deleteById(id));
	}
	
	@PostMapping("/customers/{id}/addOrder")
	public ResponseEntity<String> addOrder(@RequestBody Orders order , @PathVariable int id){
		String str = orderService.addOrder(order, id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added " + str);
	}

}