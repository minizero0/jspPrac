package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleServlet02
 */
@WebServlet("/lifeCycle")
public class ExampleServlet02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destroy 호출");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init 호출");
	}
	
}
