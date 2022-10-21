<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.deptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>dept Table</h2>
<hr>
<jsp:useBean id="dao" class = "com.sist.dao.deptDAO"></jsp:useBean>
<table border = "1">
<thead>
	<tr>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>부서위치</th>
	</tr>
</thead>
<%
	int counter = 0;
	ArrayList<deptVO> list = dao.findAll();
	for(deptVO d : list){
		%>
		<tr>
			<td><%=d.getDno() %></td>
			<td><%=d.getDname() %></td>
			<td><%=d.getDloc() %></td>
		</tr>
		<%
		counter++;
	}
%>
</table>
<h2>총 레코드 : <%=counter %></h2>
</body>
</html>