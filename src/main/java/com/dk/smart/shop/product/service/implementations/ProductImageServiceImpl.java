package com.dk.smart.shop.product.service.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.smart.shop.product.entities.ProductImage;
import com.dk.smart.shop.product.repository.ProductImageRepository;
import com.dk.smart.shop.product.service.ProductImageService;


@Service
public class ProductImageServiceImpl implements ProductImageService{

	@Autowired
	ProductImageRepository imageRepo;
	
	private final String PATH = "C:\\Users\\durga\\OneDrive\\Desktop\\Full Stack\\Backend\\springboot_projects\\smart_shop_product_images\\smart phones\\";
	
	/**
	 * This method saves the product image in MySQL DB
	 * 
	 * @param MultipartFile
	 * 
	 * @return ProductImage
	 * 
	 * @throws IllegalStateException
	 * @throws IOException
	 * 
	 */
	@Override
	public ProductImage uploadImage(MultipartFile file) throws IllegalStateException, IOException {
		
		String fullPath = PATH + file.getOriginalFilename();
		ProductImage pImage = new ProductImage();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImagePath(fullPath);
		
		file.transferTo(new File(fullPath));
		
		return imageRepo.save(pImage);
	}

	/**
	 * This method retrives the product image by name from MySQL DB
	 * 
	 * @param String
	 * 
	 * @return byte[]
	 * 
	 * @throws IOException
	 * 
	 */
	@Override
	public byte[] downloadImage(String fileName) throws IOException {
		
		Optional<ProductImage> imageObject = imageRepo.findByName(fileName);
        String fullPath = imageObject.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());
	}

}
