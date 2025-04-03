package com.test.MachineTestPro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="product")
public class Product { 
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	Long pId; 
	String pName; 
	double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long pId, String pName, double price, Category category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.category = category;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
