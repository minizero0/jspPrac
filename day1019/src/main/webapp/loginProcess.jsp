<%@page import="com.sist.dao.MemberDAO1"%>
<%@page import="com.sist.vo.MemberVO"%>
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
		MemberVO b = new MemberVO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		b.setId(id);
		
		b.setPwd(pwd);
		MemberDAO1 dao = new MemberDAO1();
		if(dao.isMember(id, pwd)){
			session.setAttribute("login", "yes");
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("login.html");
		}
	%>
</body>
</html>