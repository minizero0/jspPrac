package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class UpdateBookOKAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getInstance();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		String publisher = request.getParameter("publisher");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVO bv = new BookVO();
		bv.setBookid(bookid);
		bv.setBookname(bookname);
		bv.setPublisher(publisher);
		bv.setPrice(price);
		
		int re = dao.updateBook(bv);
		String msg = "도서 수정에 성공하였습니다.";
		if(re <= 0) {
			msg = "도서 수정에 실패하였습니다.";
		}
		request.setAttribute("msg", msg);
		
		return "updateBookOK.jsp";
	}
}
