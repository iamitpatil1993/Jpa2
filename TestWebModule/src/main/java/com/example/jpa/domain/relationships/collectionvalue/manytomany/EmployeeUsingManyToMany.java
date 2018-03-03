package com.example.jpa.domain.relationships.collectionvalue.manytomany;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeUsingManyToMany extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeUsingManyToManyDemoBean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		Integer employeeId = null;
		Integer projectId = null;
		String emploteeName = req.getParameter("employeeName");
		String projectName = req.getParameter("projectName");
		if (req.getParameter("employeeId") != null)
			employeeId = Integer.parseInt(req.getParameter("employeeId"));
		if (req.getParameter("projectId") != null)
			projectId = Integer.parseInt(req.getParameter("projectId"));
		switch (method) {
		case "employee":
			bean.createEmployee(emploteeName);
			break;
		case "project":
			bean.createProject(projectName);
			break;
		case "assignProjectToEmployee":
			bean.assignProjectToEmployee(employeeId, projectId);
			break;
		case "assignEmployeeToProject":
			bean.addEmployeeToProject(employeeId, projectId);
			break;
		case "removeProjectFromEmployee":
			bean.removeProjectFromEmployee(employeeId, projectId);
			break;
		case "removeEmployeeFromProject":
			bean.removeEmployeeFromProject(employeeId, projectId);
			break;
		default:
			resp.getWriter().println("Invalid option :: " + method);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {/*

		String method = req.getParameter("method");
		Integer employeeId = null;
		Integer projectId = null;
		if (req.getParameter("employeeId") != null)
			employeeId = Integer.parseInt(req.getParameter("employeeId"));
		if (req.getParameter("projectId") != null)
			projectId = Integer.parseInt(req.getParameter("projectId"));
		switch (method) {
		case "findEmployee":
			bean.findEmployeeById(employeeId);
			break;
		case "findProjectMembers":
			bean.findAllEmployeesByProject(projectId);
			break;
		default:
			break;
		}
	*/}
}
