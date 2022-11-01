package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardOKAction;
import com.sist.action.DetailBoardAction;
import com.sist.action.ListBoardAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardOKAction;
import com.sist.action.insertBoardAction;
import com.sist.action.insertBoardOKAction;

/**
 * Servlet implementation class SistController
 */
@WebServlet("*.do")
public class SistController extends HttpServlet {
	HashMap<String, SistAction> map = new HashMap<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		
		
		map.put("listBoard.do", new ListBoardAction());
		map.put("insertBoard.do", new insertBoardAction());
		map.put("insertBoardOK.do", new insertBoardOKAction());
		map.put("detailBoard.do", new DetailBoardAction());
		map.put("updateBoard.do", new UpdateBoardAction());
		map.put("updateBoardOK.do", new UpdateBoardOKAction());
		map.put("deleteBoard.do", new DeleteBoardAction());
		map.put("deleteBoardOK.do", new DeleteBoardOKAction());
		
		
		super.init();
	}
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		
		SistAction action = null;
		String view = "";
		
		action = map.get(cmd);
		
		
		view = action.pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

}
