package com.example.web.servlet.relationships.onetoone.mapsid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.domain.relationships.onetoone.mapsid.EmployeeOneToOneRelMapsIdDemoBean;

/**
 * Servlet implementation class EmployeeOneToOnerelMapsIdDemoServlet
 */
public class EmployeeOneToOnerelMapsIdDemoServlet extends HttpServlet {

	@EJB
	private EmployeeOneToOneRelMapsIdDemoBean bean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		Integer employeeId = Integer.parseInt(req.getParameter("employeeId"));
		switch (method) {
		case "entity":
			bean.createParkingLotUsingMapsIdUsingEmployeeEntity(employeeId);
			break;
		case "reference":
			bean.createParkingLotUsingMapsIdUsingEmployeeReference(employeeId);
			break;
		case "createEmployee":
			bean.createEmployeeUsingMapsId();
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
