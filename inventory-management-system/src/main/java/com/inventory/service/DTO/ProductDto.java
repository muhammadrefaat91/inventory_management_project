package com.inventory.service.DTO;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.jmapper.annotations.JGlobalMap;


/**
 * @author muhammadrefaat
 *
 */
@JGlobalMap(excluded={"vendorId"})
public class ProductDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;

	@NotEmpty
	@Size(max=25)
	private String barCode;

	@NotNull
	private double costPrice;

	private byte[] image;

	private String location;

	private int maxQuantity;

	private int minQunatity;

	@NotEmpty
	@Size(max = 50)
	private String name;

	private double quantity;

	@NotNull
	private double salePrice;

	private boolean status;

	private VendorDto vendor;
	
	private int vendorId;

	public ProductDto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public double getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxQuantity() {
		return this.maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public int getMinQunatity() {
		return this.minQunatity;
	}

	public void setMinQunatity(int minQunatity) {
		this.minQunatity = minQunatity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public VendorDto getVendor() {
		return vendor;
	}

	public void setVendor(VendorDto vendor) {
		this.vendor = vendor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", barCode=" + barCode + ", costPrice=" + costPrice + ", image="
				+ Arrays.toString(image) + ", location=" + location + ", maxQuantity=" + maxQuantity + ", minQunatity="
				+ minQunatity + ", name=" + name + ", quantity=" + quantity + ", salePrice=" + salePrice + ", status="
				+ status + ", vendor=" + vendor + "]";
	}
	
	

}