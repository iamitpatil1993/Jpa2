package com.example.jpa.domain.relationships.collectionvalue.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "project_using_one_to_many")
public class ProjectUsingOneToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projectId;

	@Basic
	@Column(name = "project_name")
	private String projectName;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Calendar startDate;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Calendar endDate;

	@OneToMany(mappedBy = "workingProject")
	List<EmployeeUsingOneToMany> members = new ArrayList<>();

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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<EmployeeUsingOneToMany> getMembers() {
		return members;
	}

	
}
