package com.example.jpa.domain.embeddable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_with_embeddable")
public class EmployeeWithEmbeddable implements Serializable {

	private static final long serialVersionUID = -7276936636087714938L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "name")
	private String name;

	@Embedded
	@AttributeOverride(name = "createdDate", column = @Column(name = "created_on"))
	private AuditLog auditLog;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuditLog getAuditLog() {
		return auditLog;
	}

	public void setAuditLog(AuditLog auditLog) {
		this.auditLog = auditLog;
	}

	@Override
	public String toString() {
		return "EmployeeWithEmbeddable [employeeId=" + employeeId + ", name=" + name + ", auditLog=" + auditLog + "]";
	}
}
