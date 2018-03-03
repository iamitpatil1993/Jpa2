package com.example.jpa.domain.identitygeneration.sequence;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="employee_id_gen_sequence")
public class EmployeeIdGenSequence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8664313502458924452L;
	
	@Id
	@Basic
	@Column(name="employee_id")
	@SequenceGenerator(name = "employee_id_gen_sequence_sequence_generator", sequenceName="hibernate_sequences_shared", allocationSize=50, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_gen_sequence_sequence_generator")
	private Integer employeeId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
