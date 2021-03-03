package com.desarrollasoftware.app.dto;

public class ResponseDto {

	private int code;
	private String message;
	private String bag;

	public ResponseDto() {
		this.code = -1;
		this.message = "Hay error.";
		this.bag = "";
	}

	public ResponseDto(int code, String message, String bag) {
		super();
		this.code = code;
		this.message = message;
		this.bag = bag;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

}
