package com.example.jpa.domain.relationships.onetoone.mapsid;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee_using_maps_id")
public class EmployeeUsingMapsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8064862201194436342L;

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
	
	@OneToOne(mappedBy="employee")
	private ParkingLotUsingMapsId parkingLot;

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
		return "EmployeeUsingMapsId [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + "]";
	}

}
