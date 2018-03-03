package com.example.web.servlet.enumeration;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.enumeration.EmployeeEnumerationDemoBean;


public class EmployeeSimpleEnumerationDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmployeeEnumerationDemoBean employeeEnumerationDemoBean;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeEnumerationDemoBean.createSimpleEnumMappingEmployee();
	}
}
