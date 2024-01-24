package com.dk.smart.shop.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> handleProductNotAvailableException(
			ProductNotAvailableException productNotAvailableException, final HttpServletRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus("Failure");
		exceptionResponse.setMessage(productNotAvailableException.getMessage());
		exceptionResponse.setDateTime(LocalDateTime.now());
		exceptionResponse.setPath(request.getServletPath());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
