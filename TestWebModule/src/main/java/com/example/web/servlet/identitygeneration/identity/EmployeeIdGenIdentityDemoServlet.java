package com.example.web.servlet.identitygeneration.identity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.identitygeneration.identity.EmployeeIdGenIdentityDemoBean;

public class EmployeeIdGenIdentityDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmployeeIdGenIdentityDemoBean bean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Employee :: " + bean.findByEmployeeId(Integer.parseInt(request.getParameter("employeeId"))));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bean.create();
	}

}
