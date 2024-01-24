package com.dk.smart.shop.product.dto;

import java.util.Arrays;

import com.dk.smart.shop.product.entities.Product;

public class ProductResponseDto {

	private Product product;
	
	private byte [] image;
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	public ProductResponseDto() {
		
	}
	
	
	public ProductResponseDto(Product product, byte[] image) {
		this.product = product;
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "ProductResponseDto [product=" + product + ", image=" + Arrays.toString(image) + "]";
	}

}
