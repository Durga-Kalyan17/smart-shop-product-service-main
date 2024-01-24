package com.dk.smart.shop.product.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "product_info")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "product_name")
	@JsonProperty("product_name")
	private String productName;
	
	@Column(name = "brand_name")
	@JsonProperty("brand_name")
	private String brandName;
	
	@Column(name = "sub_category")
	@JsonProperty("sub_category")
	private String subCategory;
	
	private String category;
	
	private double price;
	
	@Column(name = "image_name")
	@JsonProperty("image_name")
	private String imageName;
	
	private String seller;
	
	@Column(name = "product_description")
	@JsonProperty("product_description")
	private String productDescription;
	
	@Column(name = "stock_left")
	@JsonProperty("stock_left")
	private int stockLeft;
	
	
//	@Transient
//	private MultipartFile image;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public int getStockLeft() {
		return stockLeft;
	}

	public void setStockLeft(int stockLeft) {
		this.stockLeft = stockLeft;
	}
	
	
	public Product() {
		
	}
	
	public Product(Long id, String productName, String brandName, String subCategory, String category, double price,
			String imageName, String seller, String productDescription, int stockLeft) {
		this.id = id;
		this.productName = productName;
		this.brandName = brandName;
		this.subCategory = subCategory;
		this.category = category;
		this.price = price;
		this.imageName = imageName;
		this.seller = seller;
		this.productDescription = productDescription;
		this.stockLeft = stockLeft;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", brandName=" + brandName + ", subCategory="
				+ subCategory + ", category=" + category + ", price=" + price + ", imageName=" + imageName + ", seller="
				+ seller + ", productDescription=" + productDescription + ", stockLeft=" + stockLeft + "]";
	}

}
