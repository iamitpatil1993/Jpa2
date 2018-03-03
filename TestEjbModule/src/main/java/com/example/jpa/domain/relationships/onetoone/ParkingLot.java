package com.example.jpa.domain.relationships.onetoone;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot implements Serializable {

	private static final long serialVersionUID = 7909501149990323547L;
	
	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parking_lot_id")
	private Integer parkingLotId;
	
	@Basic
	@Column(name="number")
	private String number;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner_id")
	private Employee employee;

	public Integer getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(Integer parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ParkingLot [parkingLotId=" + parkingLotId + ", number=" + number + ", employee=" + employee.getEmployeeId() + "]";
	} 
	
}
