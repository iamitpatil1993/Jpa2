package com.example.web.servlet.relationships.onetoone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.relationships.onetooneunidirectional.EmployeeOneToOneUnidirectionalRelDemoBean;

public class EmployeeOneToOneRelDemoServlet extends HttpServlet {

	@EJB
	private EmployeeOneToOneUnidirectionalRelDemoBean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		Integer employeeId = Integer.parseInt(req.getParameter("employeeId"));
		switch (method) {
		case "entity":
			bean.createParkingLotUsingEmployeeEntity(employeeId);
			break;
		case "reference":
			bean.createParkingLotUsingEmployeeReference(employeeId);
			break;
		case "createEmployee":
			bean.createEmployee();
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		PrintWriter printWriter = resp.getWriter();
		switch (method) {
		case "employee":
			Integer employeeId = Integer.parseInt(req.getParameter("employeeId"));
			printWriter.println(bean.findEmpoyeeById(employeeId));
			break;
		case "parkingLot":
			Integer parkingLotId = Integer.parseInt(req.getParameter("parkingLotId"));
			printWriter.println(bean.findParkingLotById(parkingLotId));
			break;
		default:
			break;
		}
	}
}
