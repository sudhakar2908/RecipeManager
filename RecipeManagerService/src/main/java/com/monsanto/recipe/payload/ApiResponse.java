package com.monsanto.recipe.payload;

public class ApiResponse {
	private Boolean success;
	private String message;
	private int status;
	
	public ApiResponse() {
	}
	
	public ApiResponse(Boolean success, String message, int status) {
		this.success = success;
		this.message = message;
		this.status = status;
	}

	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
