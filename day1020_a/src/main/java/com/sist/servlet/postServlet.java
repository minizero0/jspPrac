package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/postServlet")
public class postServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();				//request.getSession으로 세션정보 가져오기 가능
		
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h2>id : "+id+"</h2><hr>");
		out.print("<h2>pwd : "+pwd+"</h2><hr>");
		out.print("<h2>email : "+email+"</h2><hr>");
	}
	
	

}
