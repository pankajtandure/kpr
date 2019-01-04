package com.app.cca.kpr.utility;
import java.io.Serializable;

public class Response implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String payload = "";
	Object[] errors = null;
	
	public Response() {
		
	}
	
	public String ggetPayloadetPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public Object[] getErrors() {
		return errors;
	}
	public void setErrors(Object[] errors) {
		this.errors = errors;
	}

	
}
