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
		int a = 1;
		int b = 1;
		
		if(session.getAttribute("a")!=null){
			a = (Integer)session.getAttribute("a");
		}
		
		if (application.getAttribute("b")!=null){
			b = (Integer)application.getAttribute("b");
		}
		
		session.setAttribute("a", a+10);
		application.setAttribute("b", b+10);
	%>						
	
	세션변수 a : <%= a %><br>
	어플리케이션 변수 b : <%= b %><br>
	<hr>
</body>
</html>