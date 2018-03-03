package com.example.jpa.beans.identitygeneration.identity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee_id_gen_identity")
public class EmployeeIdGenIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867624262398981411L;

	@Id
	@Basic
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeIdGenIdentity [employeeId=" + employeeId + "]";
	}

}
