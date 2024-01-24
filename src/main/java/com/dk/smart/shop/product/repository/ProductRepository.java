package com.dk.smart.shop.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dk.smart.shop.product.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "SELECT * FROM smart_shop.product_info", nativeQuery = true)
	List<Product> findAllProducts();

	@Query(value = "SELECT * FROM smart_shop.product_info WHERE sub_category = :category", nativeQuery = true)
	List<Product> findAllProductsByCategory(@Param("category")String categoryName);

}
