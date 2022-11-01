package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;

public class DeleteDeptOKAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = DeptDAO.getInstance();
		
		int no = Integer.parseInt(request.getParameter("no"));
		int re = dao.deleteDept(no);
		request.setAttribute("re", re);
		
		return "deleteDeptOK.jsp";
		
	}

}
