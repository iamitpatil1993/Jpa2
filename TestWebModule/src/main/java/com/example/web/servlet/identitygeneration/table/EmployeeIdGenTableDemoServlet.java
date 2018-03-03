package com.example.web.servlet.identitygeneration.table;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.identitygeneration.table.EmployeeIdGenTableDemoBean;

/**
 * Servlet implementation class EmployeeIdGenTableDemoServlet
 */
public class EmployeeIdGenTableDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EmployeeIdGenTableDemoBean bean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bean.create();
	}
}
