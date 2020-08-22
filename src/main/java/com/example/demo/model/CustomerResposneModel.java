package com.example.demo.model;

public class CustomerResposneModel {

	private String customerId;
	private String customerName;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerResposneModel(String customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public CustomerResposneModel() {
		super();
	}
	
	@Override
	public String toString() {
		return "CustomerResposneModel [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	
	
}
