package com.app.cca.kpr.error;

public class Errors {

	private String errorCode;
	private String errorMessage;
	
	public Errors() {
		
	}
	
	public Errors(String error, String message) {
		this.errorCode=error;
		this.errorMessage=message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
