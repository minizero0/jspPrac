<%@page import="com.sist.vo.RegisterBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.RegisterMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#ffffcc">
	<jsp:useBean id="regMgr" class = "com.sist.dao.RegisterMgr"/>
	<table bordercolor = "#0000ff" border = "1">
		<tr>
			<th>ID</th>
			<th>PWD</th>
			<th>NAME</th>
			<th>NUM1</th>
			<th>NUM2</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>ZIPCODE/ADDRESS</th>
			<th>JOB</th>
		</tr>
	<%
		ArrayList<RegisterBean> list = regMgr.getRegisterList();
		int counter = list.size();
		
		for(RegisterBean b : list){
			%>
			<tr>
				<td><%=b.getId() %></td>
				<td><%=b.getPwd() %></td>
				<td><%=b.getName() %></td>
				<td><%=b.getNum1() %></td>
				<td><%=b.getNum2() %></td>
				<td><%=b.getEmail() %></td>
				<td><%=b.getPhone() %></td>
				<td><%=b.getZipcode() %>/<%=b.getAddress()%></td>
				<td><%=b.getJob() %></td>
			</tr>
			<%
		}
	%>
	</table>
	<h2>total records : <%= counter %></h2>
</body>
</html>