package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.CustDAO;
import com.sist.vo.CustVO;

/**
 * Servlet implementation class InsertCust
 */
@WebServlet("/UpdateCust")
public class UpdateCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustVO cv = new CustVO();
		cv.setId(Integer.parseInt(request.getParameter("id")));
		cv.setName(request.getParameter("name"));
		cv.setGender(request.getParameter("gender"));
		cv.setLoc(request.getParameter("loc"));
		cv.setBlood(request.getParameter("blood"));
		CustDAO dao = CustDAO.getInstance();
		int re = dao.updateCust(cv);
		PrintWriter out = response.getWriter();
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
