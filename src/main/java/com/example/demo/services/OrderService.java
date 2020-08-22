package com.example.demo.services;


import com.example.demo.model.CustomerResposneModel;
import com.example.demo.model.OrderResponseModel;
import com.example.demo.model.Orders;

public interface OrderService {

	OrderResponseModel getOrderById(int id);

	String addOrder(Orders order, int id);

	CustomerResposneModel getCustomerByOrderId(int id);

}
