package com.example.web.servlet.tablemapping;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.tablemapping.EmployeeTableMappingDemoBean;

public class EmployeeTableMappingDemoServlet extends HttpServlet {
	
	@EJB
	private EmployeeTableMappingDemoBean tableMappingDemoBean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		tableMappingDemoBean.create();
	}
}
