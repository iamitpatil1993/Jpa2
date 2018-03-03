package com.example.jpa.domain.relationships.collectionvalue.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee_using_many_to_many")
public class EmployeeUsingManyToMany implements Serializable {

	private static final long serialVersionUID = 8181881354661025580L;

	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Basic
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "employees", cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<ProjectUsingManyToMany> projects = new HashSet<>();

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

	public Set<ProjectUsingManyToMany> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectUsingManyToMany> projects) {
		this.projects = projects;
	}

	// Hashcode and equals required while removing element from collection.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
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
		EmployeeUsingManyToMany other = (EmployeeUsingManyToMany) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}

	public void addProject(ProjectUsingManyToMany project) {
		if (project != null) {
			this.projects.add(project);
			project.getEmployees().add(this);
		}
	}

	public void removeProject(ProjectUsingManyToMany project) {
		if (project != null) {
			this.projects.remove(project);
			project.getEmployees().remove(this);
		}
	}
}
