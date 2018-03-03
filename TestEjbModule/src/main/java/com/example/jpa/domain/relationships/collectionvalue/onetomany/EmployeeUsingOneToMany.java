package com.example.jpa.domain.relationships.collectionvalue.onetomany;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "employee_using_one_to_many")
public class EmployeeUsingOneToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectUsingOneToMany workingProject;

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

	public ProjectUsingOneToMany getWorkingProject() {
		return workingProject;
	}

	public void setWorkingProject(ProjectUsingOneToMany workingProject) {
		this.workingProject = workingProject;
	}

	@Override
	public String toString() {
		return "EmployeeUsingOneToMany [employeeId=" + employeeId + ", name=" + name + ", workingProject="
				+ workingProject.getProjectId() + "]";
	}

}
