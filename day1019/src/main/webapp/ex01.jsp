<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!		//선언문
		String name = "홍길동";
		int year = 2020;
		public String getName(){
			return name;
		}
	%>
	
	<%-- JSP 주석 스크립트릿 안에는 모든 자바문법을 사용할 수 있다. --%>
	<%		//자바코드(지역코드 삽입 ex) for,while,if)
		Date today = new Date();
		year += 10;
			
		//스크립트릿 출력하기 위해 out 내장객체 이용 가능.
		out.print(today+"<br>");
		out.print(name+"<br>");
		out.print(year+"<br>");
	%>
	<hr>
	<%= today%><br> <!-- 값출력 -->
	<%= today.getYear() + 1900 %><br>
	<%= name %><br>
	<%= getName() %><br>
	<%= year %><br>	
</body>
</html>