package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "account_balance")
	private int accountBalance;

	
	//@JsonIgnore 
	@JsonIgnoreProperties("customer")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer", orphanRemoval = true)
	private List<Orders> orders = new ArrayList<>();

	@Embedded
	@Column(nullable = true)
	private Address address;

	public List<Orders> getOrders() {
		return orders;
	}

	public void addOrder(Orders order) {
		this.orders.add(order);
	}

	public void removeOrder(Orders order) {
		this.orders.remove(order);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(String customerName, int i, Address add) {
		super();
		this.address = add;
		this.customerName = customerName;
		this.accountBalance = i;
	}

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", accountBalance="
				+ accountBalance + "]";
	}

}
