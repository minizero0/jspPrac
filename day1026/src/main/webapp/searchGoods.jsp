<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.GoodsDAO"/>
	<% 
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("searchName")!=null){
		String searchName =request.getParameter("searchName");
		dao.findByName(searchName);
	}
	
	
	%>
</body>
</html>