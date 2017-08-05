package com.inventory.service.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.jmapper.annotations.JGlobalMap;

/**
 * @author muhammadrefaat
 *
 */
@JGlobalMap
@JsonIgnoreProperties(value = { "id", "address" })
public class CustomerDto implements Serializable{

	private int id;
	
	@Size(max=50) 
	@NotEmpty
	
	private String firstName;
	
	@Size(max=50)
	@NotEmpty
	private String lastName;
	
	@Size(max=100) 
	@NotEmpty
	private String address;
	
	@Pattern(regexp="(^$|[0-9]{11})")
	@NotEmpty
	private String mobile;
 
	@NotNull
	private int maxNumber;
	
	@NotNull
	private int allowedAmount;
	
	private boolean status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
 
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobileNumber) {
		this.mobile = mobileNumber;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	public int getAllowedAmount() {
		return allowedAmount;
	}

	public void setAllowedAmount(int allowedAmount) {
		this.allowedAmount = allowedAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		CustomerDto other = (CustomerDto) obj;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", mobile=" + mobile + ", maxNumber=" + maxNumber + ", allowedNumberPayment="
				+ allowedAmount + ", status=" + status + "]";
	}
 
}
