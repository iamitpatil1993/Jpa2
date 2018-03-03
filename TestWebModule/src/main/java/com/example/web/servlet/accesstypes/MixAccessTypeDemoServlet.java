package com.example.web.servlet.accesstypes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.jpa.beans.accesstypes.mix.MixAccessTypeDemoBean;
import com.example.jpa.domain.accesstypes.mix.EmployeeMixAccess;

public class MixAccessTypeDemoServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(MixAccessTypeDemoServlet.class);

	@EJB
	private MixAccessTypeDemoBean mixAccessTypeDemoBean;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mixAccessTypeDemoBean.create();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();

		try {
			EmployeeMixAccess employee = mixAccessTypeDemoBean.get(Integer.parseInt(req.getParameter("employeeId")));
			printWriter.println(employee.toString());
		} catch (Exception e) {
			printWriter.println("Invalid employeeId...");
			e.printStackTrace();
		}
		printWriter.flush();
		resp.flushBuffer();
	}
}
