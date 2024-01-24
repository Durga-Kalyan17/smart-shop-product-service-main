package com.dk.smart.shop.product.exception;


public class ProductNotAvailableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9089944572647994277L;
	
	public ProductNotAvailableException (String message) {
		super(message);
	}

}
