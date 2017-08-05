package com.inventory.exception;

import java.util.HashMap;
import java.util.Map;

public class RuntimeSystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ResponseError restResponseError;
	private Map<String, String> fieldsMap = new HashMap<>(); 

	public RuntimeSystemException() {
	}

	public RuntimeSystemException(ResponseError restResponseError) {
 		this.restResponseError = restResponseError;
	}

	public ResponseError getRestResponseError() {
		return restResponseError;
	}

	public void setRestResponseError(ResponseError restResponseError) {
		this.restResponseError = restResponseError;
	}

	@Override
	public String toString() {
		return "RuntimeSystemException [restResponseError=" + restResponseError + ", fieldsList=" + fieldsMap + "]";
	}

	public Map<String, String> getFieldsMap() {
		return fieldsMap;
	}

	public void setFieldsMap(Map<String, String> fieldsList) {
		this.fieldsMap = fieldsList;
	}
 
	 
	 
}
