package com.dk.smart.shop.product.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExceptionResponse {

	private String status;
	
	private String message;
	
	@JsonProperty("time_stamp")
	private LocalDateTime dateTime;
	
	private String path;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	public ExceptionResponse() {
		
	}

	
	@Override
	public String toString() {
		return "ExceptionResponse [status=" + status + ", message=" + message + ", dateTime=" + dateTime + ", path="
				+ path + "]";
	}

	
}
