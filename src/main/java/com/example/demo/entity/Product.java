package com.example.demo.entity;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private Integer productPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;
	
	@PrePersist
	private void onCreate(){
		purchaseDate = new Date();
	}
	
	public Product() {
	}

	public Product(Integer productId, String productName, Integer productPrice, Date purchaseDate) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.purchaseDate = purchaseDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
