package com.example.jpa.domain.relationships.onetoone;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -765079563358652438L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "first_name")
	private String fName;

	@Basic
	@Column(name = "last_name")
	private String lName;
	
	@OneToOne(mappedBy="employee", fetch=FetchType.EAGER)
	private ParkingLot parkingLot;
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + ", parkingLot="
				+ parkingLot.getParkingLotId() + "]";
	}
}
