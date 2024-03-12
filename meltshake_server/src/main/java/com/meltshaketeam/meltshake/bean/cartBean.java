package com.meltshaketeam.meltshake.bean;



public class cartBean{
	
	private int id;
	private String productcode;
	private int quantity;
	
	public cartBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public cartBean(int id, String productcode, int quantity) {
		super();
		this.id = id;
		this.productcode = productcode;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}