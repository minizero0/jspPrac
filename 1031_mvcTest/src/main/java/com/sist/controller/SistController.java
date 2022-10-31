package com.sist.controller;

import java.io.IOException;

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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		
		SistAction action = null;
		String view = "";
		
		if(cmd.equals("listBoard.do")) {
			action = new ListBoardAction();
		}else if(cmd.equals("insertBoard.do")){
			action = new insertBoardAction();
		}else if(cmd.equals("insertBoardOK.do")){
			action = new insertBoardOKAction();
		}else if(cmd.equals("detailBoard.do")) {
			action = new DetailBoardAction();
		}else if(cmd.equals("updateBoard.do")) {
			action = new UpdateBoardAction();
		}else if(cmd.equals("updateBoardOK.do")) {
			action = new UpdateBoardOKAction();
		}else if(cmd.equals("deleteBoard.do")) {
			action = new DeleteBoardAction();
		}else if(cmd.equals("deleteBoardOK.do")) {
			action = new DeleteBoardOKAction();
		}
		
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
