package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int re = 0;
		
		String oper = request.getParameter("oper");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		int price = 0;
		String bookname = "";
		String publisher = "";
		BookVO b = null;
		
		BookDAO dao = BookDAO.getInstance();
		PrintWriter out = response.getWriter();
		
		
		if(!oper.equals("delete")) {
			price = Integer.parseInt(request.getParameter("price"));
			bookname = request.getParameter("bookname");
			publisher = request.getParameter("publisher");
			b = new BookVO();
			b.setBookid(bookid);
			b.setBookname(bookname);
			b.setPrice(price);
			b.setPublisher(publisher);
		
		}
		switch(oper) {
			case "add":re = dao.insertBook(b);break;
			case "update":re = dao.updateBook(b);break;
			case "delete":re = dao.deleteBook(bookid);break;
		}
		
		out.print(re);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
