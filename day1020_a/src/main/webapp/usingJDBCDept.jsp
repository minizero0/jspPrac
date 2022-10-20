<%@page import="com.sist.dao.deptMGR"%>
<%@page import="com.sist.vo.deptBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="db" class = "com.sist.vo.deptBean"/>
	<jsp:useBean id="dao" class ="com.sist.dao.deptMGR"  />
	<table bordercolor = "#0000ff" border = "1">
		<tr>
			<th>DNO</th>
			<th>DNAME</th>
			<th>DLOC</th>
			
		</tr>
	<%
		ArrayList<deptBean> list = dao.getDeptList();
		int counter = list.size();
		
		for(deptBean b : list){
			%>
			<tr>
				<td><%=b.getDno() %></td>
				<td><%=b.getDname() %></td>
				<td><%=b.getDloc() %></td>
			</tr>
			<%
		}
	%>
	</table>
	<h2>total records : <%= counter %></h2>
	<%
		
	%>
</body>
</html>