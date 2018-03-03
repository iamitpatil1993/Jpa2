package com.example.web.servlet.elementcollection;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.elementcollection.ElementCollectionDemoBean;

public class ElementCollectionDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ElementCollectionDemoBean bean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		String name = null;
		Integer empId = null;
		switch (method) {
		case "createEmployee":
			bean.createEmployee();
			break;
		case "createEmployeeWithCollections":
			bean.createEmployeeWithCollections();
			break;
		case "updateEmploteeName":
			name = request.getParameter("name");
			empId = Integer.parseInt(request.getParameter("employeeId"));
			bean.updateEmploteeName(name, empId);
			break;
		case "addNickNameToEmployee":
			name = request.getParameter("name");
			empId = Integer.parseInt(request.getParameter("employeeId"));
			bean.addNickNameToEmployee(empId, name);
			break;
		case "removeNickNameToEmployee":
			name = request.getParameter("name");
			empId = Integer.parseInt(request.getParameter("employeeId"));
			bean.removeNickNameToEmployee(empId, name);
			break;
		case "displayEmployeeAddress":
			empId = Integer.parseInt(request.getParameter("employeeId"));
			bean.displayEmployeeAddress(empId);
			break;	
		case "getEmployee":
			empId = Integer.parseInt(request.getParameter("employeeId"));
			bean.getEmployee(empId);
			break;
		default:
			response.getWriter().println("Invalid option :: " + method);
		}
	}

}
