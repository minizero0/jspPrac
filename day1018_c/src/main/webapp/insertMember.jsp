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
		String method = request.getMethod();
		if(method.equals("GET")){
			%>
			<h2>회원등록</h2>
			<hr>
			<form action="insertMember.jsp" method="post">
				아이디 : <input type="text" name="id"> <br>
				암호 : <input type="password" name="pwd"> <br>
				이름  : <input type="text" name="name"> <br>
				<input type="submit" value="등록">
			</form>
			<%
		}else{
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			
			String url = request.getRequestURL().toString();
			String uri = request.getRequestURI().toString();
			String ip = request.getRemoteAddr(); 				//ip주소 가져오기
			
			MemberVO m = new MemberVO(id, pwd, name);
			MemberDAO1 dao = new MemberDAO1();
			int re = dao.insertMember(m);
			if(re > 0){
				out.print("<h2>등록성공</h2>");
			}else{
				out.print("<h2>등록실패</h2>");
			}
			out.print("<a href = 'insertMember.jsp'>새로운 회원 등록</a>");
		}
	%>
</body>
</html>