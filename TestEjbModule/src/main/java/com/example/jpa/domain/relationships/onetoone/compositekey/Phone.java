package com.example.jpa.domain.relationships.onetoone.compositekey;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "phone_using_composite_key")
public class Phone implements Serializable {

	@Basic
	@Id
	@Column(name = "number")
	private String number;
	
	@OneToOne
	@JoinColumns(value= {
			@JoinColumn(name = "company_id", referencedColumnName = "company_id"),
			@JoinColumn(name = "employee_number", referencedColumnName = "employee_number"),
	})
	private EmployeeUsingCompositeKey employee;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public EmployeeUsingCompositeKey getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeUsingCompositeKey employee) {
		this.employee = employee;
	}
	
	
	
}
