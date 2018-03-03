package com.example.jpa.domain.relationships.onetoone.mapsid;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "parking_lot_using_maps_id")
public class ParkingLotUsingMapsId implements Serializable {

	private static final long serialVersionUID = 7909501149990323547L;
	
	// In order to use mapsId, i.e common primary key as that of parent table, we should not provide 
	// @GeneratedValue annotation here.
	@Basic
	@Id
	@Column(name="id")
	private Integer id;
	
	@Basic
	@Column(name="number")
	private String number;
	
	// And provide JoinCOlumn as above attribute that we marked as @Id
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	@MapsId
	private EmployeeUsingMapsId employee;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public EmployeeUsingMapsId getEmployee() {
		return employee;
	}


	public void setEmployee(EmployeeUsingMapsId employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "ParkingLotUsingMapsId [id=" + id + ", number=" + number + ", employee=" + employee.getEmployeeId() + "]";
	}
}
