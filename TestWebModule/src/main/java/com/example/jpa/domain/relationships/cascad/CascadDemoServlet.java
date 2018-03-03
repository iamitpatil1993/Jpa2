package com.example.jpa.domain.relationships.cascad;

import java.io.IOException;
import javax.ejb.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CascadDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private CascadDemoBean bean;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String method = request.getParameter("method");
		switch (method) {
		case "createPostWithoutCascad":
			bean.createPost(request.getParameter("postName"));
			break;
		case "createPostWithCascadEnabled":
			bean.createPostWithCascadEnabled(request.getParameter("postName"));
			break;
		default:
			break;
		}
	}
}
