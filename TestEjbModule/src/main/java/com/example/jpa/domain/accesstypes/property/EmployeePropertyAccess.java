package com.example.jpa.domain.accesstypes.property;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_property_access")
public class EmployeePropertyAccess {

	private Integer employeeId;
	private String fName;
	private String lName;
	private Integer paSalary;
	private Date dob;
	
	@Id
	@Basic
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	@Basic
	@Column(name="first_name")
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	@Basic
	@Column(name="last_name")
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Basic
	@Column(name="per_anum_salary")
	public Integer getPaSalary() {
		return paSalary;
	}
	
	
	public void setPaSalary(Integer paSalary) {
		this.paSalary = paSalary;
	}
}
