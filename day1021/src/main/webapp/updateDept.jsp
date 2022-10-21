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
<jsp:useBean id="dao" class ="com.sist.dao.deptDAO"/>
<%
	int dno =  Integer.parseInt(request.getParameter("dno"));
	deptVO d = dao.findByNo(dno);
%>

<h2>부서 수정</h2>
<form action="updateDeptProcess.jsp?dno1=<%=d.getDno()%>" method = "post">
	부서번호 : <input type = "text" name = "dno" value = "<%=d.getDno()%>"><br>
	부서이름 : <input type = "text" name = "dname" value = "<%=d.getDname()%>"><br>
	부서위치 : <input type = "text" name = "dloc" value = "<%=d.getDloc()%>"><br>
	<input type = "submit" value = "등록">
	<input type = "reset" value = "취소">
</form>
</body>
</html>