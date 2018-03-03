package com.example.web.servlet.embeddable;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.domain.embeddable.EmbeddableDemoBean;

public class EmbeddableDemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmbeddableDemoBean bean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bean.createEmployee();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bean.getEmployee(Integer.parseInt(request.getParameter("employeeId")));
	}

}
