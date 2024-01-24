package com.dk.smart.shop.product.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.smart.shop.product.dto.ProductResponseDto;
import com.dk.smart.shop.product.entities.Product;

@Service
public interface ProductService {

	public Product addProduct(Product item, MultipartFile productImage) throws IllegalStateException, IOException;
	
	public List<ProductResponseDto> getAllProducts(String categoryName);
	
	public ProductResponseDto getProduct(Long id) throws IOException;
}
