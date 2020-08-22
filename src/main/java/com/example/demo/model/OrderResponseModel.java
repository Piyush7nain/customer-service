package com.example.demo.model;

public class OrderResponseModel {

	private int id;
	private String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public OrderResponseModel(int id, String details) {
		super();
		this.id = id;
		this.details = details;
	}
	public OrderResponseModel() {
		super();
	}
	@Override
	public String toString() {
		return "OrderResponseModel [id=" + id + ", details=" + details + "]";
	}
	
	
}
