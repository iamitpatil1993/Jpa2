package com.example.jpa.domain.identitygeneration.table;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="employee_id_gen_table")
public class EmployeeIdGenTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3160372689848114622L;
	
	@TableGenerator(name="employee_id_gen_table_gen", pkColumnValue="employee_id_gen_table", initialValue=1)
	@Id
	@Basic
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="employee_id_gen_table_gen")
	private Integer employeeId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
