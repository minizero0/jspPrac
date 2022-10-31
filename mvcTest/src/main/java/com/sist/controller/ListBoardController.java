package com.sist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class ListBoardController
 */
@WebServlet("/listBoard.do")
public class ListBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNUM = 1;
		if(request.getParameter("pageNUM") != null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));	
		}
		request.setCharacterEncoding("utf-8");
		HashMap<String,String> map = new HashMap<>();
		String searchColumn = "";
		String keyword = "";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("map") != null){
			map = (HashMap<String,String>)session.getAttribute("map");
			searchColumn = map.get("searchColumn");
			keyword = map.get("keyword");
		}
		
		if(request.getParameter("keyword")!=null){
			searchColumn = request.getParameter("searchColumn");
			keyword = request.getParameter("keyword");
			
		}
		
		if(request.getParameter("keyword")!=null) {
			keyword = request.getParameter("keyword");
			searchColumn = request.getParameter("searchColumn");
		}
		
		BoardDAO dao = new BoardDAO();
		map.put("searchColumn", searchColumn);
		map.put("keyword", keyword);
		
		ArrayList<BoardVO> list = dao.listBoard(pageNUM, map);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", dao.totalPage);
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("listBoard.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
