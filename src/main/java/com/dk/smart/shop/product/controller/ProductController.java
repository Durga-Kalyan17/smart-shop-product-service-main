package com.dk.smart.shop.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dk.smart.shop.product.dto.ProductResponseDto;
import com.dk.smart.shop.product.entities.Product;
import com.dk.smart.shop.product.service.ProductService;

@RestController
@RequestMapping("/smart/shop/product")
public class ProductController {
// test
	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Product> addProductApi(@RequestPart("product") Product product,
			@RequestPart("image") MultipartFile productImage) throws IllegalStateException, IOException {
		
		Product addedProduct = productService.addProduct(product, productImage);
		return ResponseEntity.status(HttpStatus.OK).body(addedProduct);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<ProductResponseDto>> getAllProductsApi(
			@RequestParam(name = "category", required = false, defaultValue = "") String categoryName) {
		
		List<ProductResponseDto> productlist = productService.getAllProducts(categoryName);
		return ResponseEntity.status(HttpStatus.OK).body(productlist);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProductResponseDto> getProductByIdApi(@PathVariable("id") Long productId) throws IOException {
		
		ProductResponseDto response = productService.getProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
