<%@page import="com.sist.dao.DeptDAO"%>
<%@page import="com.sist.vo.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String method = request.getMethod();
	
		if(method.equals("POST")){
			request.setCharacterEncoding("utf-8");
			int dno = Integer.parseInt(request.getParameter("dno"));
			String dname = request.getParameter("dname");
			String dloc = request.getParameter("dloc");
			
			DeptVO d = new DeptVO();
			d.setDno(dno);
			d.setDname(dname);
			d.setDloc(dloc);
			
			DeptDAO dao = new DeptDAO();
			int re = dao.insertDept(d);
			
			if(re >0){
				out.print("<h2>등록성공</h2>");
			}
		}
	%>
</body>
</html>