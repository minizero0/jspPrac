package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;

public class InsertBookAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = 0;
		String title = "새글작성";
		BookDAO dao = BookDAO.getInstance();
		int bookid = dao.maxBookid();
		if(request.getParameter("no")!=null) {
			no = Integer.parseInt(request.getParameter("no"));
			title = "답글작성";
		}
		request.setAttribute("bookid", bookid);
		request.setAttribute("no", no);
		request.setAttribute("title", title);
		
		return "insertBook.jsp";
	}

}
