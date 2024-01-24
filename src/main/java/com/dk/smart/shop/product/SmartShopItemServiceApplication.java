package com.dk.smart.shop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class SmartShopItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartShopItemServiceApplication.class, args);
	}

}
