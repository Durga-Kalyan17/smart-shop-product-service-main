package com.dk.smart.shop.product.service.implementations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.smart.shop.product.dto.ProductResponseDto;
import com.dk.smart.shop.product.entities.Product;
import com.dk.smart.shop.product.exception.ProductNotAvailableException;
import com.dk.smart.shop.product.repository.ProductRepository;
import com.dk.smart.shop.product.service.ProductImageService;
import com.dk.smart.shop.product.service.ProductService;

import jakarta.transaction.Transactional;



/**
 * @author DurgaKalyan
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductImageService productImageService;

	/**
	 * This method saves the product details in MySQL DB
	 * 
	 * @param Product
	 * @param MultipartFile
	 * 
	 * @return ResponseEntity<Product>
	 * 
	 * @throws IllegalStateException
	 * @throws IOException
	 * 
	 */
	@Override
	@Transactional
	public Product addProduct(Product product, MultipartFile productImage) throws IllegalStateException, IOException {
		
		Product savedProduct = new Product(product.getId(), product.getProductName(), product.getBrandName()
								,product.getSubCategory() ,product.getCategory(), product.getPrice()
								, productImage.getOriginalFilename(), product.getSeller()
								, product.getProductDescription(), product.getStockLeft());
		
		productImageService.uploadImage(productImage);
		productRepository.save(savedProduct);
		
		return savedProduct;
	}

	/**
	 * This Method retrives all the products and products with same name as list from MySQL DB
	 * 
	 * @param String
	 * 
	 * @return List<ProductResponseDto>
	 * 
	 * @throws ProductNotAvailableException
	 * 
	 */
	@Override
	public List<ProductResponseDto> getAllProducts(String categoryName) {
		
		List<Product> allProducts;
		
		if(categoryName.isEmpty())
			allProducts = productRepository.findAllProducts();
		else
			allProducts = productRepository.findAllProductsByCategory(categoryName.toUpperCase());
		
		List<ProductResponseDto> allProductsResponse = new ArrayList<>();
		allProducts.forEach(p -> {
			ProductResponseDto productResponseDto = new ProductResponseDto();
			try {
				byte [] image = productImageService.downloadImage(p.getImageName());
				productResponseDto.setProduct(p);
				productResponseDto.setImage(image);
				allProductsResponse.add(productResponseDto);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		return allProductsResponse;
	}

	/**
	 * This Method retrives a single product by id from MySQL DB
	 * 
	 * @param Long
	 * 
	 * @return ProductResponseDto
	 * 
	 * @throws ProductNotAvailableException
	 * @throws IOException
	 * 
	 */
	@Override   
	public ProductResponseDto getProduct(Long id) throws IOException {

		Optional<Product> optionalItem = productRepository.findById(id);
		
		if(optionalItem.isEmpty()) 
			throw new ProductNotAvailableException("Item is Out Of Stock");
		
		Product product = optionalItem.get();
		
		byte [] image = productImageService.downloadImage(product.getImageName());
		
		ProductResponseDto productResponse = new ProductResponseDto();
		productResponse.setProduct(product);
		productResponse.setImage(image);
		
		return productResponse;
	}

}
