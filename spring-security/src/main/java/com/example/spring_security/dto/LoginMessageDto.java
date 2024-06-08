package com.example.spring_security.dto;

public class LoginMessageDto {
	
	private String message;
	
	private Boolean status;


	public LoginMessageDto(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}


	public LoginMessageDto() {
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
