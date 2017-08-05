package com.inventory.exception;

public class ResponseError {

	private String message;
	
	private String fieldName;
	
	public ResponseError() {
	}

	public ResponseError(String message) {
		this.message = message;
	}
	
	public ResponseError(String message, String fieldName) {
		this.message = message;
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ResponseError [message=" + message + ", fieldName=" + fieldName + "]";
	};

}
