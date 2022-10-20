<%@page import="com.sist.vo.MemberVO"%>
<%@page import="com.sist.dao.MemberDAO1"%>
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDAO1 dao = new MemberDAO1();
		if(dao.isMember(id, pwd)){
			MemberVO m = dao.findById(id);
			session.setAttribute("member", m);
			response.sendRedirect("main.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>