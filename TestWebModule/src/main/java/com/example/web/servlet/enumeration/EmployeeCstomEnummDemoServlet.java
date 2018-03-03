package com.example.web.servlet.enumeration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.enumeration.EmployeeCustomEnumDemoBean;

public class EmployeeCstomEnummDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private EmployeeCustomEnumDemoBean employeeCustomEnumDemoBean;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeCustomEnumDemoBean.createCustomEnumMappingEmployee();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(employeeCustomEnumDemoBean.findByEmployeeId(Integer.parseInt(req.getParameter("employeeId"))));
		printWriter.flush();
		resp.flushBuffer();
	}
}
