package com.example.jpa.beans.relationships;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.example.jpa.domain.relationships.collectionvalue.onetomany.EmployeeUsingOneToMany;
import com.example.jpa.domain.relationships.collectionvalue.onetomany.ProjectUsingOneToMany;

@Stateless
public class OneToManyDemoBean {

	private static final Logger LOGGER = Logger.getLogger(OneToManyDemoBean.class);

	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;

	// Create Only employee without project
	// Assign project to existin employee
	// Create project as well as employee at a time
	// Create Project
	// Get employee by Id
	// Get all projects
	// Get all employees working on particular ptoject

	public EmployeeUsingOneToMany createEmployee() {

		EmployeeUsingOneToMany employeeUsingOneToMany = new EmployeeUsingOneToMany();
		employeeUsingOneToMany.setName("amit");
		em.persist(employeeUsingOneToMany);
		LOGGER.info("Employee Saved successfully with Id :: " + employeeUsingOneToMany.getEmployeeId());
		return employeeUsingOneToMany;
	}

	public void createProject(String projectName) {

		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.YEAR, 1);
		ProjectUsingOneToMany project = new ProjectUsingOneToMany();
		project.setProjectName(projectName);
		project.setStartDate(Calendar.getInstance());
		project.setEndDate(endDate);
		em.persist(project);
		LOGGER.info("Project Saved successfully with Id :: " + project.getProjectId());
	}

	public void assignProjectToEmployee(Integer employeeId, Integer projectId) {

		EmployeeUsingOneToMany emlpoyee = em.find(EmployeeUsingOneToMany.class, employeeId);
		ProjectUsingOneToMany project = em.getReference(ProjectUsingOneToMany.class, projectId);

		if (emlpoyee == null) {
			LOGGER.error("Invalid employeeId :: " + employeeId);
			return ;
		}
		if (project == null) {
			LOGGER.error("Invalid projectId :: " + projectId);
			return ;
		}
		emlpoyee.setWorkingProject(project);
		em.merge(emlpoyee);
		LOGGER.info("project assigned successfully");
	}

	public void createEmployeeWithProject(Integer projectId, String employeeName) {
		EmployeeUsingOneToMany employeeUsingOneToMany = new EmployeeUsingOneToMany();
		employeeUsingOneToMany.setName(employeeName);
		employeeUsingOneToMany.setWorkingProject(em.getReference(ProjectUsingOneToMany.class, projectId));
		em.persist(employeeUsingOneToMany);
		LOGGER.info("Employee Saved with project successfully with Id :: " + employeeUsingOneToMany.getEmployeeId());
	}

	public void findEmployeeById(Integer employeeId) {
		EmployeeUsingOneToMany employee = em.find(EmployeeUsingOneToMany.class, employeeId);
		LOGGER.info("Employee details :: " + employee);
	}

	public void findAllEmployeesByProject(Integer projectId) {
		ProjectUsingOneToMany project = em.find(ProjectUsingOneToMany.class, projectId);
		LOGGER.info("Employees of project :: " + project.getProjectName() + " are :: ");
		project.getMembers().stream().map(EmployeeUsingOneToMany::toString).forEach(LOGGER::info);
	}
}

