package com.inventory.common;

public class VendorSearchCriteria {

	private String name;
	private int companyId;
	private String country;
 	private String city;
	private Boolean status;

	public VendorSearchCriteria() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VendorSearchCriteria [name=" + name + ", companyId=" + companyId + ", country=" + country + ", city="
				+ city + ", status=" + status + "]";
	}
	
	
}
