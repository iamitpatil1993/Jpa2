package com.example.jpa.domain.enumeration;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "employee_custom_enum_enumeration")
@Access(AccessType.FIELD)
public class EmployeeCustomEnumEnumeration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	@Column(name = "first_name")
	private String fName;

	@Column(name = "last_name")
	private String lName;
	
	@Transient
	private AccessAuthority accessAuthority;
	
	@Transient
	private Integer accessAuthorityValue;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public AccessAuthority getAccessAuthority() {
		return accessAuthority;
	}

	public void setAccessAuthority(AccessAuthority accessAuthority) {
		this.accessAuthority = accessAuthority;
	}
	
	@Basic
	@Access(AccessType.PROPERTY)
	@Column(name="access_authority")
	public Integer getAccessAuthorityValue() {
		return accessAuthority.getAuthority();
	}

	public void setAccessAuthorityValue(Integer accessAuthorityValue) {
		this.accessAuthorityValue = accessAuthorityValue;
		this.accessAuthority = AccessAuthority.findByAccessValue(accessAuthorityValue);
	}

	@Override
	public String toString() {
		return "EmployeeCustomEnumEnumeration [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName
				+ ", accessAuthority=" + accessAuthority + ", accessAuthorityValue=" + accessAuthorityValue + "]";
	}
	
	
}
