package com.example.jpa.domain.relationships.onetoone.compositekey;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee_using_composite_key")
public class EmployeeUsingCompositeKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeCompositeKey employeeId;

	@Basic
	@Column(name = "name")
	private String name;

	public EmployeeCompositeKey getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeCompositeKey employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
