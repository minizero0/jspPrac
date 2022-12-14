package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class DetailBookAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getInstance();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookVO bv = dao.findByBookid(bookid);
		request.setAttribute("bv", bv);
		return "detailBook.jsp";
	}
}
