package com.inventory.common;

public class ProductSearchCriteria {

	private String name;
	private String barCode;
 	private int VendorId;
 	private double quantity;
	private Boolean status;

	public ProductSearchCriteria() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getVendorId() {
		return VendorId;
	}

	public void setVendorId(int vendorId) {
		VendorId = vendorId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductSearchCriteria [name=" + name + ", barCode=" + barCode + ", VendorId=" + VendorId + ", quantity="
				+ quantity + ", status=" + status + "]";
	}
	
}
