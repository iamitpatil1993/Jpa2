package com.example.jpa.domain.accesstypes.mix;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;

@Entity
@Table(name = "employee_mix_access")
@Access(value = AccessType.FIELD)
public class EmployeeMixAccess {

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "per_anum_salary")
	private Integer paSalary;

	@Transient
	private String fName;

	@Transient
	private String lName;

	@Transient
	private String fullName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getPaSalary() {
		return paSalary;
	}

	public void setPaSalary(Integer paSalary) {
		this.paSalary = paSalary;
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

	@Access(AccessType.PROPERTY)
	@Column(name = "fulll_name")
	public String getFullName() {
		return fName.concat(" ").concat(lName);
	}

	public void setFullName(String fullName) {
		String[] names = fullName.split(" ");
		fName = names[0];
		lName = names[1];
	}

	@Override
	public String toString() {
		return "EmployeeMixAccess [employeeId=" + employeeId + ", paSalary=" + paSalary + ", fName=" + fName
				+ ", lName=" + lName + ", fullName=" + fullName + "]";
	}

}
