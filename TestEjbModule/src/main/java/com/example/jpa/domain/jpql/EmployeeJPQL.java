package com.example.jpa.domain.jpql;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import org.apache.log4j.Logger;

@Entity
@Table(name = "employee_jpql")
@NamedQueries({
	@NamedQuery(
			name = "EmployeeJPQL.findSalaryByEmployeeId",
			query = "SELECT e.salary FROM EmployeeJPQL e WHERE e.isDeleted = false AND e.employeeId = :employeeId"
	),
	@NamedQuery(
			name = "EmployeeJPQL.findAllBetweenHiredDates",
			query = "SELECT e From EmployeeJPQL e WHERE e.isDeleted = false AND e.createdDate BETWEEN :fromDate AND :toDate"
	),
	@NamedQuery(
			name = "EmployeeJPQL.findAllFNameAndLName",
			query = "SELECT NEW com.example.jpa.domain.jpql.EmployeeJPQL(e.fName, e.lName) FROM EmployeeJPQL e ORDER BY e.employeeId ASC"
	)
})
public class EmployeeJPQL implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EmployeeJPQL.class);

	@Basic
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "first_name")
	private String fName;

	@Basic
	@Column(name = "last_name")
	private String lName;

	@Basic
	@Column(name = "salary")
	private Integer salary;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentJPQL department;

	@Basic
	@Column(name = "created_date")
	private Calendar createdDate;

	@Basic
	@Column(name = "updated_date")
	private Calendar updatedDate;

	@Basic
	@Column(name = "is_deleted")
	boolean isDeleted;

	public EmployeeJPQL(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	public EmployeeJPQL() {
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public DepartmentJPQL getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentJPQL department) {
		this.department = department;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@PrePersist
	public void prePersist() {
		LOGGER.info("Inside prePersist...");
		createdDate = Calendar.getInstance();
		updatedDate = createdDate;
		isDeleted = false;
	}

	@PreUpdate
	public void preUpdate() {
		LOGGER.info("Inside preUpdate...");
		updatedDate = Calendar.getInstance();
	}

	@Override
	public String toString() {
		return "EmployeeJPQL [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary
				+ ", department=" + department.getDepartmentId() + "]";
	}


}
