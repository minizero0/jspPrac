<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	name : ${name }<br>
	year : ${year }<br>
	isMember : ${isMember }<br>
	m : ${m }<br>
	list : ${list }<br>
	<%
		String []arr = (String[])session.getAttribute("arr");
		for(String data : arr){
			out.print(data+"<br>");
		}
	%>
	
</body>
</html>