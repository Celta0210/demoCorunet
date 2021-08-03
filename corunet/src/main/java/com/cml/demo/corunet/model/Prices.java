package com.cml.demo.corunet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Prices {

	@Id
	private int id;
	
	@Column(nullable = false)
	private int brand_id;

	@Column(nullable = false)
	private int product_id;

	@Column(nullable = false)
	private int priority;

	@Column(nullable = false)
	private float price;

	@Column(nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private Date starDate;

	@Column(nullable = false)
	private Date endDate;

	public Prices(int id, int brand_id, int product_id, int priority, float price, String currency, Date starDate,
			Date endDate) {
		super();
		this.id = id;
		this.brand_id = brand_id;
		this.product_id = product_id;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
		this.starDate = starDate;
		this.endDate = endDate;
	}

	public Prices() {
		super();
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	
	
}
