package com.inventory.common;

import java.util.Map;
import java.util.Map.Entry;

import com.inventory.exception.RuntimeSystemException;


public class CommonUtils {

	public static void handleException(RuntimeSystemException ex, Map<String, Object> model) {
		for (Entry<String, String> fieldsMap : ex.getFieldsMap().entrySet()) {
			model.put(fieldsMap.getKey(), fieldsMap.getValue());
		}
	}
	
	
	public static boolean isEmpty(String object) {
		return object == null || object.isEmpty();
	}
}
