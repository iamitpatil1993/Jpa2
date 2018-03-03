package com.example.jpa.domain.jpql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "department_jpql")
public class DepartmentJPQL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DepartmentJPQL.class);

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Integer departmentId;

	@Basic
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department")
	private Set<EmployeeJPQL> employees = new LinkedHashSet<>();

	@OneToMany(mappedBy = "department")
	private Set<ProjectJPQL> projects = new LinkedHashSet<>();
	
	public Set<ProjectJPQL> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectJPQL> projects) {
		this.projects = projects;
	}

	@Basic
	@Column(name = "created_date")
	private Calendar createdDate;

	@Basic
	@Column(name = "updated_date")
	private Calendar updatedDate;
	@Basic
	@Column(name = "is_deleted")
	boolean isDeleted;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeJPQL> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeJPQL> employees) {
		this.employees = employees;
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
		return "DepartmentJPQL [departmentId=" + departmentId + ", name=" + name + ", employees=" + employees
				+ ", projects=" + projects + "]";
	}


}
