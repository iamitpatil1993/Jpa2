package com.example.web.servlet.accesstypes;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.jpa.beans.accesstypes.property.PropertyAccessTypeDemoBean;

public class PropertyAccessTypedemoServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(PropertyAccessTypedemoServlet.class);
	
	@EJB
	private PropertyAccessTypeDemoBean propertyAccessTypeDemoBean;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		propertyAccessTypeDemoBean.create();
	}

}
