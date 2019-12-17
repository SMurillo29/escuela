package com.escuela.escuela.services;

public class Issuccess {
	
	private boolean state;
	private String Message;
	
	public Issuccess(boolean state, String message) {
		super();
		this.state = state;
		Message = message;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
		

}
