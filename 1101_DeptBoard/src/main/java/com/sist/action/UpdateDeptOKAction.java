package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

public class UpdateDeptOKAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		DeptVO dv = new DeptVO();
		
		int no = Integer.parseInt(request.getParameter("dno"));
		String dname = request.getParameter("dname");
		String dloc = request.getParameter("dloc");
		
		dv.setDno(no);
		dv.setDname(dname);
		dv.setDloc(dloc);
		int re = dao.updateDept(dv);
		request.setAttribute("re", re);
		
		return "updateDeptOK.jsp";
	}

}
