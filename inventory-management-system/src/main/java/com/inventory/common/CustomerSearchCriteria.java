package com.inventory.common;

public class CustomerSearchCriteria {

	private String firstName;
	private String lastName;
 	private String mobile;
	private Boolean status;

	public CustomerSearchCriteria() {
	}
	
	public CustomerSearchCriteria(String firstName, String lastName,  String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobileNumber) {
		this.mobile = mobileNumber;
	}

	@Override
	public String toString() {
		return "SearchCriteria [firstName=" + firstName + ", lastName=" + lastName 
				+ ", mobile=" + mobile + "]";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
