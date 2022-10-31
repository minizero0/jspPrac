package com.sist.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class DetailBoardAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
BoardDAO dao = new BoardDAO();
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO bv = dao.findByNo(no);
		request.setAttribute("bv", bv);
		
		
		return "detailBoard.jsp";
	}

}
