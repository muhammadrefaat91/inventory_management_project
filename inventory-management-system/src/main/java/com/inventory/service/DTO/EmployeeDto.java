package com.inventory.service.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.googlecode.jmapper.annotations.JGlobalMap;

/**
 * @author muhammadrefaat
 *
 */
@JGlobalMap
public class EmployeeDto implements Serializable{

	
	private int id;

	@Past
	@NotEmpty
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;

	@NotEmpty
	@Size(max=45)
	private String firstName;

	private String gender;

	@NotEmpty
	@Size(max=45)
	private String lastName;

	@Pattern(regexp="(^$|[0-9]{11})")
	@NotEmpty
	private String mobile;

	@NotEmpty
	private String password;

	@NotEmpty
	@Size(max=45)	
	private String userName;
	
	@NotEmpty
	@Size(max=500)
	private String department;
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	 

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		EmployeeDto other = (EmployeeDto) obj;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName + ", gender=" + gender
				+ ", lastName=" + lastName + ", mobile=" + mobile + ", password=" + password + ", userName=" + userName
				+ "]";
	}
	
	
	
}
