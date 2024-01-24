package com.dk.smart.shop.product.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.smart.shop.product.entities.ProductImage;


@Service
public interface ProductImageService {

	ProductImage uploadImage(MultipartFile file) throws IllegalStateException, IOException;
	
	byte[] downloadImage(String fileName) throws IOException;
}
