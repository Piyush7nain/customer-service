package com.example.demo.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerResposneModel;
import com.example.demo.model.OrderResponseModel;
import com.example.demo.model.Orders;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	private ModelMapper modelMapper = new ModelMapper();
	

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  
	@Override 
	@Transactional
	public OrderResponseModel getOrderById(int id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Optional<Orders> order = orderRepository.findById(id);
		logger.info("Order -> {}", order);
		OrderResponseModel model = modelMapper.map(order.get(),OrderResponseModel.class);
		logger.info("ResponseModel -> {}" ,model);
		return model;
	}
	 

	@Override
	@Transactional
	public String addOrder(Orders order, int id) {
		Customer customer = customerRepository.findById(id).get();
		customer.addOrder(order);
		order.setCustomer(customer);
		orderRepository.save(order);
		return "Added oder with orderId = " + order.getId() + " to customer " + customer.getCustomerName();
	}


	@Override
	@Transactional
	public CustomerResposneModel getCustomerByOrderId(int id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Optional<Orders> order = orderRepository.findById(id);
		logger.info("Order -> {}", order);
		CustomerResposneModel model = modelMapper.map(order.get().getCustomer(),CustomerResposneModel.class);
		logger.info("ResponseModel -> {}" ,model);
		return model;
	}
	
	

	

}
