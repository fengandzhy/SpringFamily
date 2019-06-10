package com.citi.springboot.upload.domain;

import java.io.Serializable;

public class JsonData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4795010420982053561L;

	private int statusCode;
	
	private String msg;

	
	public JsonData() {
		super();
	}

	public JsonData(int statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}	
}
