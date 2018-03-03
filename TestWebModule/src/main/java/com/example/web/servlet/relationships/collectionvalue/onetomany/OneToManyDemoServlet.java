package com.example.web.servlet.relationships.collectionvalue.onetomany;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.relationships.OneToManyDemoBean;

public class OneToManyDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private OneToManyDemoBean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		Integer employeeId = null;
		Integer projectId = null;
		if (req.getParameter("employeeId") != null)
			employeeId = Integer.parseInt(req.getParameter("employeeId"));
		if (req.getParameter("projectId") != null)
			projectId = Integer.parseInt(req.getParameter("projectId"));

		switch (method) {
		case "employee":
			bean.createEmployee();
			break;
		case "project":
			bean.createProject(req.getParameter("projectName"));
			break;
		case "assign":
			bean.assignProjectToEmployee(employeeId, projectId);
			break;
		case "createEmployeeWithProject":
			bean.createEmployeeWithProject(projectId, req.getParameter("employeeName"));
			break;
		default:
			resp.getWriter().println("Invalid option :: " + method);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
	}
}
