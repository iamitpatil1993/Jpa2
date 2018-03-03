package com.example.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.jpql.JPQLDemoBean;

public class JPQLDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private JPQLDemoBean bean;

	public JPQLDemoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		switch (method) {
		case "findAllEmployees":
			bean.findAllEmployees();;
			break;
		case "findAllEmployeesWithProjection":
			bean.findAllEmployeesWithProjection();
			break;
		case "findAllEmployeesByFName":
			bean.findAllEmployeesByFName(request.getParameter("fName"));
			break;
		case "findAllemployeesByDepartmentName":
			bean.findAllemployeesByDepartmentName(request.getParameter("departmentName"));
			break;
		case "findAllemployeesByDepartmentNameWithProjection":
			bean.findAllemployeesByDepartmentNameWithProjection(request.getParameter("departmentName"));
			break;
		case "aggregatesByDepartmentId":
			bean.aggregatesByDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
			break;	
		case "findEmployeeSalaryUsingNamedQuery":
			bean.findEmployeeSalaryUsingNamedQuery(Integer.parseInt(request.getParameter("employeeId")));
			break;
		case "findEmployeeHiredBetweenDates":
			try {
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				Date fromDate;
				fromDate = formater.parse(request.getParameter("fromDate"));
				Date toDate = formater.parse(request.getParameter("toDate"));
				bean.findEmployeeHiredBetweenDates(fromDate, toDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;	
		case "findAllEmployeeFNameAndLNameUsingConstructorExpression":
			bean.findAllEmployeeFNameAndLNameUsingConstructorExpression();
			break;	
		case "findAllWithPagination":
			bean.findAllWithPagination(Integer.parseInt(request.getParameter("pageNo")), Integer.parseInt(request.getParameter("pageSize")));
			break;	
		case "findAllWithFlushModeAuto":
			bean.findAllWithFlushModeAuto();
			break;		
		case "findAllWithFlushModeCommit":
			bean.findAllWithFlushModeCommit();
			break;
		case "findAllEmployeeByDepartmentWithDepartmentEntityAsAQueryParameter":
			bean.findAllEmployeeByDepartmentWithDepartmentEntityAsAQueryParameter(Integer.parseInt(request.getParameter("departmentId")));
			break;
		case "selectMultipleEntitiesInSelectClauseAndCheckAreTheymanaged":
			bean.selectMultipleEntitiesInSelectClauseAndCheckAreTheymanaged();
			break;
		case "updateEmployeeByEmployeeId":
			bean.updateEmployeeByEmployeeId(Integer.parseInt(request.getParameter("employeeId")), request.getParameter("fName"));
			break;
		case "findEmployeesByDepartmentName":
			bean.findEmployeesByDepartmentName(request.getParameter("departmentName"));
			break;
		case "findEmployeesWithJoinCondition":
			bean.findEmployeesWithJoinCondition(Integer.parseInt(request.getParameter("departmentId")));
			break;
		case "findAllDepartmentsWithEmployeeUsingFetchJoin":
			bean.findAllDepartmentsWithEmployeeUsingFetchJoin();
			break;
		case "findAllDepartmentWithProjectsAndEmployees":
			bean.findAllDepartmentWithProjectsAndEmployees();
			break;
		case "findAllDepartmentWithProjectsAndEmployeesUsingDistinct":
			bean.findAllDepartmentWithProjectsAndEmployeesUsingDistinct();
			break;		
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		switch (method) {
		case "createEmployee":
			bean.createEmployee(request.getParameter("fname"), request.getParameter("lname"),
					Integer.parseInt(request.getParameter("salary")));
			break;
		case "createDepartment":
			bean.createDepartment(request.getParameter("departmentName"));
			break;
		case "assign":
			bean.assignDepartmentToEmployee(Integer.parseInt(request.getParameter("employeeId")),
					Integer.parseInt(request.getParameter("departmentId")));
			break;
		default:
			break;
		}
	}
}
