<%@page import="java.util.Enumeration"%>
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
		
		String queryString = request.getQueryString();
		
		Enumeration<String> list = request.getParameterNames();			//파라미터 전달되는 name을 파악하기위해 사용.
		while(list.hasMoreElements()){
			String key = list.nextElement();
			String value = request.getParameter(key);
			out.print(key + "==>"+value+ "<br>");
		}
	%>
	
	queryString : <%= queryString %><br>
	list : <%= list %><br>
</body>
</html>