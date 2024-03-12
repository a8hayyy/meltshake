package com.meltshaketeam.meltshake.bean;


public class productBean {
	
	private String productcode;
	private String flavour;
    private String size;
    private int quantity;
    private double price;
    
    
    public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public productBean(String productcode, String flavour, String size, int quantity, double price ) {
		super();
		this.flavour = flavour;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.productcode = productcode;
	}
    
    public productBean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}