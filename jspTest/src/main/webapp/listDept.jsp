<%@page import="com.sist.dao.DeptDAO"%>
<%@page import="com.sist.vo.DeptVO"%>
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
<%
/* 	ArrayList<DeptVO> list = new ArrayList<DeptVO>();
	list.add(new DeptVO(10,"총무팀", "서교동"));
	list.add(new DeptVO(20,"기획팀", "판교"));
	list.add(new DeptVO(30,"개발팀", "판교")); */
	
	
	DeptDAO dao = new DeptDAO();
	ArrayList<DeptVO> list = dao.list();
	%>

<table border = "1">
	<tr>
		<td>부서번호</td>
		<td>부서명</td>
		<td>부서위치</td>
	</tr>
	
	<%
		for(DeptVO d : list){
			%>
				<tr>
					<td><%=d.getDno() %></td>
					<td><%=d.getDname() %></td>
					<td><%=d.getDloc() %></td>
				</tr>
			<%
		}
	%>
	
</table>
</body>
</html>