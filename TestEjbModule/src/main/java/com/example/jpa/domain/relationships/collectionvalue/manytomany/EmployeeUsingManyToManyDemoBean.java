package com.example.jpa.domain.relationships.collectionvalue.manytomany;
import javax.persistence.*;

import org.apache.log4j.Logger;

import javax.ejb.*;

@Stateless
public class EmployeeUsingManyToManyDemoBean {

	private static final Logger LOGGER = Logger.getLogger(EmployeeUsingManyToManyDemoBean.class);
	
	@PersistenceContext(unitName = "JPADB")
	private EntityManager em;
	
	
	public void createEmployee(final String name) {
		EmployeeUsingManyToMany employee = new EmployeeUsingManyToMany();
		employee.setName(name);
		em.persist(employee);
		LOGGER.info("Employee saved successfully using ID :: " + employee.getEmployeeId());
	}
	

	public void createProject(final String projectName) {
		ProjectUsingManyToMany project = new ProjectUsingManyToMany();
		project.setName(projectName);
		em.persist(project);
		LOGGER.info("Project saved successfully using ID :: " + project.getProjectId());
	}
	
	public void assignProjectToEmployee(Integer employeeId, Integer projectId) {
		EmployeeUsingManyToMany employeeUsingManyToMany = em.find(EmployeeUsingManyToMany.class, employeeId);
		ProjectUsingManyToMany project = em.getReference(ProjectUsingManyToMany.class, projectId);
		employeeUsingManyToMany.addProject(project);
		em.merge(employeeUsingManyToMany);
		LOGGER.info("Project with Id :: " + projectId + " added to employee with employee id :: " + employeeId);
		LOGGER.info("projects count :: " + employeeUsingManyToMany.getProjects().size());
	}
	
	public void addEmployeeToProject(Integer employeeId, Integer projectId) {
		ProjectUsingManyToMany projectUsingManyToMany = em.find(ProjectUsingManyToMany.class, projectId);
		EmployeeUsingManyToMany employee = em.getReference(EmployeeUsingManyToMany.class, employeeId);
		projectUsingManyToMany.addEmployee(employee);
		em.merge(projectUsingManyToMany);
		LOGGER.info("Employee with Id :: " + employeeId + " added to project with project id :: " + projectId);
	}
	
	public void removeProjectFromEmployee(Integer employeeId, Integer projectId) {
		EmployeeUsingManyToMany employeeUsingManyToMany = em.find(EmployeeUsingManyToMany.class, employeeId);
		ProjectUsingManyToMany project = em.getReference(ProjectUsingManyToMany.class, projectId);
		employeeUsingManyToMany.removeProject(project);
		LOGGER.info("Project with Id :: " + projectId + " removed from employee with employee id :: " + employeeId);
		LOGGER.info("projects count :: " + employeeUsingManyToMany.getProjects().size());
	}
	
	public void removeEmployeeFromProject(Integer employeeId, Integer projectId) {
		ProjectUsingManyToMany projectUsingManyToMany = em.find(ProjectUsingManyToMany.class, projectId);
		EmployeeUsingManyToMany employee = em.getReference(EmployeeUsingManyToMany.class, employeeId);
		projectUsingManyToMany.removeEmployee(employee);
		LOGGER.info("Employee with Id :: " + employeeId + " added to project with project id :: " + projectId);
		LOGGER.info("Employee count :: " +projectUsingManyToMany.getEmployees().size());
	}
}
