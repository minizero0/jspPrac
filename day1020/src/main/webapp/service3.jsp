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
		if(session.getAttribute("member")!=null){
			MemberVO m = (MemberVO)session.getAttribute("member");
			out.print(m.getId() + "님 로그인하셨습니다.<hr>");
			
		}else{
			out.print("비정상적인 접근입니다.");
			response.sendRedirect("login.jsp");
		}
	%>
	<h2>서비스3입니다.</h2>
</body>
</html>