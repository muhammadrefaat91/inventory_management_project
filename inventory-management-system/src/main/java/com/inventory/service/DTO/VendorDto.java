package com.inventory.service.DTO;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.jmapper.annotations.JGlobalMap;

/**
 * @author muhammadrefaat
 *
 */
@JGlobalMap(excluded={"companyId"})
public class VendorDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@Size(max=100) 
	@NotEmpty
	private String address;
	
	@Size(max=50)
	@NotEmpty
	private String name;

	@Size(max=50) 
	@NotEmpty
	private String city;

	@Size(max=50) 
	@NotEmpty
	private String country;

	private byte[] logo;

	@Pattern(regexp="(^$|[0-9]{11})")
	@NotEmpty
	private String mobile;

	@Size(max=100)
	@NotEmpty
	private String notes;

	
	private boolean status;
 
	private CompanyDto company;
	
	private int companyId;

	public VendorDto() {
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		VendorDto other = (VendorDto) obj;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendorDto [id=" + id + ", address=" + address + ", name=" + name + ", city=" + city + ", country="
				+ country + ", logo=" + Arrays.toString(logo) + ", mobile=" + mobile + ", notes=" + notes + ", status="
				+ status + ", company=" + company + ", companyId=" + companyId + "]";
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}