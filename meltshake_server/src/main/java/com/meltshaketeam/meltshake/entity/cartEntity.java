package com.meltshaketeam.meltshake.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Cart")
//@Data @ToString @NoArgsConstructor @AllArgsConstructor
public class cartEntity{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="productcode")
	private String productcode;
	
	@Column(name = "quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	
	public String getProductcode() {
		return productcode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public cartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cartEntity(String productcode, int id, int quantity) {
		super();
		this.productcode = productcode;
		this.id = id;
		this.quantity = quantity;
	}
	
	
	
}