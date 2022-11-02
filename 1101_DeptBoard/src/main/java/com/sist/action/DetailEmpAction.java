package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class DetailEmpAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eno = Integer.parseInt(request.getParameter("eno"));
		EmpDAO dao = EmpDAO.getInstance();
		EmpVO ev = dao.findByEno(eno);
		request.setAttribute("ev", ev);
		
		return "detailEmp.jsp";
	}

}
