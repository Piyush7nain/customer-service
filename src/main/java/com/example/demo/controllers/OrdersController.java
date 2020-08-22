package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerResposneModel;
import com.example.demo.model.OrderResponseModel;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseModel> getOrderById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(id));
	}

	@GetMapping("/{id}/customer")
	public ResponseEntity<CustomerResposneModel> getCustomerOfOrder(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getCustomerByOrderId(id));
	}

}
