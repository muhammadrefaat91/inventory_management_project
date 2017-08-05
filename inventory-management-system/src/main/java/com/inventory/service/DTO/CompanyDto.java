package com.inventory.service.DTO;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.jmapper.annotations.JGlobalMap;


/**
 * @author muhammadrefaat
 *
 */
@JGlobalMap
public class CompanyDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;

	@NotEmpty
	@Size(max=50)
	private String address;

	@NotEmpty
	@Email
	@Size(max=50)
	private String email;

	@NotEmpty
	@Size(max=50)
	private String faxNumber;

	private byte[] logo;

	@NotEmpty
	@Size(max=100)
	private String name;

	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{11})")
	private String phoneNumber;

	@NotEmpty
	@Size(max=50)
	private String registrationNumber;
	
	 
	public CompanyDto() {
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((faxNumber == null) ? 0 : faxNumber.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		CompanyDto other = (CompanyDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (faxNumber == null) {
			if (other.faxNumber != null)
				return false;
		} else if (!faxNumber.equals(other.faxNumber))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", address=" + address + ", email=" + email + ", faxNumber=" + faxNumber
				+ ", logo=" + Arrays.toString(logo) + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", registrationNumber=" + registrationNumber + "]";
	}

	 
}