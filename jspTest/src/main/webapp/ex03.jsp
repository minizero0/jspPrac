<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String name = "홍길동";
		int year = 2022;
		public void addYear(int n){
			year += n;
		}
	%>
	
	<%
		String addr = "서울시 마포구 서교동";
		out.print("주소:"+addr);
		out.print("이름:"+name);
		out.print("연도:"+year);
		addYear(5);
	%>
	
	<hr>
	연도 : <%= year %>
</body>
</html>