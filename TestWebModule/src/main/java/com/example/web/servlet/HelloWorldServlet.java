package com.example.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jpa.beans.HelloWorldBean;

public class HelloWorldServlet extends HttpServlet {

	@EJB
	private HelloWorldBean helloWorldBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();
		if(helloWorldBean != null) {
			printWriter.println("Bean injected successfully, cheers....!!");
			printWriter.println("Greeting from bean is :: " + helloWorldBean.getGreetingMessage());
		} else {
			printWriter.print("Error while injecting bean");
		}
		printWriter.close();
		resp.flushBuffer();
	}

}
