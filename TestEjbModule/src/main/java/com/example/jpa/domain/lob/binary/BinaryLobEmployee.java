package com.example.jpa.domain.lob.binary;

import javax.persistence.*;

@Entity
@Table(name = "binary_lob_employee")
public class BinaryLobEmployee {

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Lob
	@Column(name = "employee_profile_pic")
	private byte[] employeeImage;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public byte[] getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(byte[] employeeImage) {
		this.employeeImage = employeeImage;
	}
}
