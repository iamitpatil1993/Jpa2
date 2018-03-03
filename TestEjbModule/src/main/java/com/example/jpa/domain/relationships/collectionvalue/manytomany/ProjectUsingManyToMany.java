package com.example.jpa.domain.relationships.collectionvalue.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "project_using_many_to_many")
public class ProjectUsingManyToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projectId;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "project_employee", 
	joinColumns = { @JoinColumn(name = "project_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "employee_id") })
	private Set<EmployeeUsingManyToMany> employees = new HashSet<>();

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeUsingManyToMany> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeUsingManyToMany> employees) {
		this.employees = employees;
	}

	// hascode() and equals() required while removing project from Employee project collection attribute
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectUsingManyToMany other = (ProjectUsingManyToMany) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	public void addEmployee(EmployeeUsingManyToMany employee) {
		if (employee != null) {
			this.employees.add(employee);
			employee.getProjects().add(this);
		}
	}
	
	public void removeEmployee(EmployeeUsingManyToMany employee) {
		if (employee != null) {
			this.employees.remove(employee);
			employee.getProjects().remove(this);
		}
	}
}
