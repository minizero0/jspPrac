package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

public class UpdateDeptAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		int no = Integer.parseInt(request.getParameter("no"));
		DeptVO dv = dao.findByNo(no);
		request.setAttribute("dv", dv);
		return "updateDept.jsp";
	}
}
