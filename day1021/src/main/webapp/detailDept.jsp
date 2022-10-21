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
<jsp:useBean id="dao" class = "com.sist.dao.deptDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	int dno =  Integer.parseInt(request.getParameter("dno"));
	deptVO dv = dao.findByNo(dno);
	
%>
<h2>부서번호 : <%=dv.getDno() %></h2>
<h2>부서이름 : <%=dv.getDname() %></h2>
<h2>부서위치 : <%=dv.getDloc() %></h2>
<hr>
<a href = "updateDept.jsp?dno=<%=dno%>">수정</a>

</body>
</html>