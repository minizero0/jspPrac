package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		MemberDAO dao = new MemberDAO();
		dao.insertAdmin();
		System.out.println("init동작함!");
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		MemberDAO dao = new MemberDAO();
		dao.deleteAdmin();
		System.out.println("destroy동작함");
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoGet동작");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); 
		
		PrintWriter out = response.getWriter();
		String str = "<h1>";
		str += "get방식의 요청입니다.";
		str += "</h1>";
		str += "<p>이름 : " +name+"</p>";
		str += "<p>나이 : " +age+"</p>";
		out.print(str);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPOST동작");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		String str = "<h1>";
		str += "post 방식의 요청입니다.";
		str += "</h1>";
		str += "<p>이름 : " +name+"</p>";
		str += "<p>나이 : " +age+"</p>";
		out.print(str);
		out.close();
	}

}
