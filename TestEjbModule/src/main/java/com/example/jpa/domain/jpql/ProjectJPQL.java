package com.example.jpa.domain.jpql;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "project_jpql")
public class ProjectJPQL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projectId;

	@Basic
	@Column(name = "prject_name")
	private String projectName;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentJPQL department;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public DepartmentJPQL getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentJPQL department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "ProjectJPQL [projectId=" + projectId + ", projectName=" + projectName + ", department=" + department.getName()
				+ "]";
	}
}
