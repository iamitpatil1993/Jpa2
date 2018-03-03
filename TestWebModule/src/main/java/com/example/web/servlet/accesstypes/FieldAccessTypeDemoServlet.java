package com.example.web.servlet.accesstypes;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.jpa.beans.accesstypes.field.FieldAccessTypeDemoBean;

public class FieldAccessTypeDemoServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(FieldAccessTypeDemoServlet.class);
	
	@EJB
	private FieldAccessTypeDemoBean fieldAccessTypeDemoBean;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		fieldAccessTypeDemoBean.create();
	}

}
