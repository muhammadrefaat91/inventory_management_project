package com.inventory.common;

public enum Status {

	ENABLED(true, "Enabled"), DISABLED(false, "Disabled");
	
	private Boolean value;
	private String name;
	
	Status(boolean value, String name) {
		this.value = value;
		this.name = name;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Status[] getAllStatus() {
		return Status.values();
	} 
}
