package com.dev.mealsOnWheel.payload;

public class IssueHandling {
	
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		message = message;
	}
	
	public IssueHandling(int status, String message) {
        this.status = status;
        this.message = message;
    }
	
	
	
	

}
