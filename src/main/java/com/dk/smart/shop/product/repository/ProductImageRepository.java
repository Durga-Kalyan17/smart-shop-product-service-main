package com.dk.smart.shop.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dk.smart.shop.product.entities.ProductImage;


@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{

	Optional<ProductImage> findByName(String fileName);

}
