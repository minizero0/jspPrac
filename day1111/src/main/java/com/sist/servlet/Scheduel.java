package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.ChatmessageDAO;
import com.sist.dao.ScheduelDAO;
import com.sist.vo.ChatMessageVO;
import com.sist.vo.ScheduelVO;

/**
 * Servlet implementation class ChatMessage
 */
@WebServlet("/Scheduel")
public class Scheduel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scheduel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduelDAO dao = ScheduelDAO.getInstance();
		ArrayList<ScheduelVO> list = dao.findAll();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ScheduelDAO dao = ScheduelDAO.getInstance();
		ScheduelVO cv = new ScheduelVO();
		
		String name = request.getParameter("name");
		String day = request.getParameter("day");
		
		cv.setName(name);
		cv.setDay(day);
		int re = dao.addCust(cv);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(re);
		out.close();
	}

}
