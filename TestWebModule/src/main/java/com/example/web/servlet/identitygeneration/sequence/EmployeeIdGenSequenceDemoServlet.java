package com.example.web.servlet.identitygeneration.sequence;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.identitygeneration.sequence.EmployeeIdGenSequenceDemoBean;

/**
 * Servlet implementation class EmployeeIdGenSequenceDemoServlet
 */
public class EmployeeIdGenSequenceDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EmployeeIdGenSequenceDemoBean bean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bean.create();
	}
}
