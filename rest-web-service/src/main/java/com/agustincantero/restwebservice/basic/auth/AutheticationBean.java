package com.agustincantero.restwebservice.basic.auth;

public class AutheticationBean {

	private String message;

	public AutheticationBean(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message%s]", message);
	}
}
