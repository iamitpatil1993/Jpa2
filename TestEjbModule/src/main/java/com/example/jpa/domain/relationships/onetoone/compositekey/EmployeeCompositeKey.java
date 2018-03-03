package com.example.jpa.domain.relationships.onetoone.compositekey;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class EmployeeCompositeKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "company_id")
	private Integer componyId;

	@Basic
	@Column(name = "employee_number")

	private Integer employeeNumber;

	public Integer getComponyId() {
		return componyId;
	}

	public void setComponyId(Integer componyId) {
		this.componyId = componyId;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componyId == null) ? 0 : componyId.hashCode());
		result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
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
		EmployeeCompositeKey other = (EmployeeCompositeKey) obj;
		if (componyId == null) {
			if (other.componyId != null)
				return false;
		} else if (!componyId.equals(other.componyId))
			return false;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		return true;
	}
	
}
