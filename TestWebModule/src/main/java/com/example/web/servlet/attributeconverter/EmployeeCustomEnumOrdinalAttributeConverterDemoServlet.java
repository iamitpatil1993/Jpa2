package com.example.web.servlet.attributeconverter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.attributeconverter.EmployeeCustomEnumOrdinalAttributeConverterDemoBean;
import com.example.jpa.domain.attributeconverter.EmployeeCustomEnumStringAttributeConverter;
public class EmployeeCustomEnumOrdinalAttributeConverterDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EmployeeCustomEnumOrdinalAttributeConverterDemoBean bean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();
		//EmployeeCustomEnumOrdinalAttributeConverter entity = bean.findEmployeeCustomEnumOrdinalAttributeConverterByEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		EmployeeCustomEnumStringAttributeConverter entity1 = bean.findEmployeeCustomEnumStringAttributeConverterByEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		//printWriter.println("Ordinal :: " + entity.toString());
		printWriter.println("String :: " + entity1.toString());
		printWriter.flush();
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//bean.createEmployeeCustomEnumOrdinalAttributeConverter();
		bean.createEmployeeCustomEnumStringAttributeConverter();
	}

}
