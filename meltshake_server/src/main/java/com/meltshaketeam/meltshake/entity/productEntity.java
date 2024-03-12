package com.meltshaketeam.meltshake.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
//@Data @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class productEntity{
	
//	@Id
//	@Column(name = "productcode", columnDefinition = "DEFAULT XXX")
//	private String productcode;
	
	@Column(name = "productcode", nullable = false, unique = true)
	@Id
	private String productcode;

	
	@Column(name = "flavour")
	private String flavour;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	public productEntity( String productcode, String flavour,  String size,  int quantity,
			double price) {
		super();
		this.productcode = productcode;
		this.flavour = flavour;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}

	public productEntity() {
		super();
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

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}



	

	
	
	
}